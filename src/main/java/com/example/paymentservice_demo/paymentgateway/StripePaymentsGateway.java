package com.example.paymentservice_demo.paymentgateway;

import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;

public class StripePaymentsGateway implements PaymentGateway{

    @Value("${stripe.apiKey}")
    private String apiKey;

    @Override
    public String getPaymentLink(Long amount, String phoneNumber, String name) throws RuntimeException{
        try{
        Stripe.apiKey = this.apiKey;
        Price price = getPrice(amount);

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1MoC3TLkdIwHu7ixcIbKelAC")
                                        .setQuantity(1L)
                                        .build()
                        ).setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder().setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT).setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder().setUrl("https://scaler.com").build()).build())
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
        }catch (StripeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private Price getPrice(Long amount){
        try {


            PriceCreateParams params =
                    PriceCreateParams.builder()
                            .setCurrency("usd")
                            .setUnitAmount(amount)
                            .setRecurring(
                                    PriceCreateParams.Recurring.builder()
                                            .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                            .build()
                            )
                            .setProductData(
                                    PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                            )
                            .build();

            return Price.create(params);
        }catch (StripeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
