package com.example.paymentservice_demo.paymentgateway;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {

    String getPaymentLink(Long amount, String phoneNumber, String name) throws RuntimeException;
}
