package com.example.finalproject.controller.client;

import com.example.finalproject.dto.PaypalDto;
import com.example.finalproject.model.NguoiDat;
import com.example.finalproject.model.User;
import com.example.finalproject.model.VeMayBay;
import com.example.finalproject.service.NguoiDatService;
import com.example.finalproject.service.UserService;
import com.example.finalproject.service.VeMayBayService;
import com.example.finalproject.service.impl.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@SessionAttributes("nguoiDatTemp")
public class PaypalController {
    @Autowired
    private PaypalService paypalService;

    @Autowired
    private VeMayBayService veMayBayService;

    @Autowired
    private UserService userService;

    @Autowired
    private NguoiDatService nguoiDatService;


    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @PostMapping("/paypal")
    public String home(
            Long maDV,
            Model model,
            NguoiDat nguoiDat
    ) {

        VeMayBay veMayBay = veMayBayService.findById(maDV).get();

        model.addAttribute("nguoiDat", nguoiDat);
        model.addAttribute("infoVe", veMayBay);

        return "client/paypal";
    }

    @PostMapping("/pay")
    public String payment(
            @ModelAttribute("order") PaypalDto order,
            NguoiDat nguoiDat,
            HttpSession session
    ) throws PayPalRESTException {
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

            session.setAttribute("nguoiDatTemp", nguoiDat);

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
            @RequestParam("PayerID") String PayerId,
            HttpSession session
    ) {
        try {
            Payment payment = paypalService.executePayment(paymentId, PayerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                String currentPrincipalName = SecurityContextHolder.getContext().getAuthentication().getName();
                Optional<User> optionalUser = userService.findByEmail(currentPrincipalName);

                NguoiDat nguoiDat = (NguoiDat) session.getAttribute("nguoiDatTemp");
                if (nguoiDat != null && optionalUser.isPresent()) {
                    nguoiDat.setIdUser(optionalUser.get().getId());
                    nguoiDatService.save(nguoiDat);
                    return "client/success";
                }
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }

        return "redirect:/";
    }
}
