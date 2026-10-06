package com.exam.pharmacyservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pharmacy")
public class PharmacyController {

    @Value("${app.branch-name}")
    private String branchName;

    @Value("${app.hotline}")
    private String hotline;

    @GetMapping("/info")
    public String getInfo() {
        return "Chi nhánh: " + branchName
                + " | Hotline: " + hotline;
    }
}
