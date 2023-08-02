package com.example.finalproject.controller.client;

import com.example.finalproject.dto.PaypalDto;
import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.service.VeMayBayService;
import com.example.finalproject.service.impl.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PaypalController {
    @Autowired
    private PaypalService paypalService;

    @Autowired
    private VeMayBayService veMayBayService;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @PostMapping("/paypal")
    public String home(Long maDV, Model model) {

        VeMayBay veMayBay = veMayBayService.findById(maDV).get();

        model.addAttribute("infoVe", veMayBay);

        return "client/paypal";
    }

    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") PaypalDto order) throws PayPalRESTException {
        try {
            Payment payment = paypalService.createPayment(
                    order.getPrice(),
                    order.getCurrency(),
                    order.getMethod(),
                    order.getIntent(),
                    order.getDescription(),
                    "http://localhost:9000/" + CANCEL_URL,
                    "http://localhost:9000/" + SUCCESS_URL
            );

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "client/cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String PayerId
    ) {
        try {
            Payment payment = paypalService.executePayment(paymentId, PayerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "client/success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }
}
