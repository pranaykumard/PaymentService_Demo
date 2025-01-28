package com.example.paymentservice_demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentDto {
    long amount;
    String orderId;
    String phoneNumber;
    String name;
}
