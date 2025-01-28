package com.example.paymentservice_demo.services;

import com.example.paymentservice_demo.paymentgateway.PaymentGateway;
import com.example.paymentservice_demo.paymentgateway.PaymentGatewayChooserStrategy;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public String getPaymentLink(Long amount, String phoneNumber, String name) throws RazorpayException {
        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.getPaymentGateway();
        return paymentGateway.getPaymentLink(amount,phoneNumber,name);
    }
}
