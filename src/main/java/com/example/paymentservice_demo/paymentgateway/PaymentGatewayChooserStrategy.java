package com.example.paymentservice_demo.paymentgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentGatewayChooserStrategy {

    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;

    private StripePaymentsGateway stripePaymentsGateway;

    public PaymentGateway getPaymentGateway() {
//        return razorpayPaymentGateway;
        //create random number generator function somewhere and call it here to check if its even or odd and call
        //either strip or razorpay based on even and odd random number generated

        return stripePaymentsGateway;
    }
}
