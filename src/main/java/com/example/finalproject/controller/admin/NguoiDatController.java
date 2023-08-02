package com.example.finalproject.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/ng-dat")
public class NguoiDatController {
    @PostMapping
    public void test(String maDV) {
        System.out.println(maDV);
    }
}
