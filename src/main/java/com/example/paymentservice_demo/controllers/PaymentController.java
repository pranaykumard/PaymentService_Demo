package com.example.paymentservice_demo.controllers;

import com.example.paymentservice_demo.dtos.InitiatePaymentDto;
import com.example.paymentservice_demo.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public String initiatePayment(@RequestBody InitiatePaymentDto initiatePaymentDto) throws RazorpayException {
        return paymentService.getPaymentLink(initiatePaymentDto.getAmount(),initiatePaymentDto.getPhoneNumber(),initiatePaymentDto.getName());

    }
}
