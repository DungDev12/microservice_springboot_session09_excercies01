package com.exam.pharmacyservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/bill")
@RefreshScope
public class BillController {

    @Value("${pharmacy.vat-rate}")
    private double vatRate;

    @PostMapping
    public ResponseEntity<?> calculateBill(
            @RequestParam double medicineTotal
    ) {
        double vat = medicineTotal * vatRate / 100;
        double total = medicineTotal + vat;

        return ResponseEntity.ok(
                Map.of(
                        "medicineTotal", medicineTotal,
                        "vatRate", vatRate,
                        "vatAmount", vat,
                        "total", total
                )
        );
    }
}