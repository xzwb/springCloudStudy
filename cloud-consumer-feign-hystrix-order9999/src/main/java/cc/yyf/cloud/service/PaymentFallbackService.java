package cc.yyf.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements  OrderService {
    @Override
    public String paymentOK(int id) {
        return "----- PaymentFallbackService fallback, wuwuwuwu paymentOK";
    }

    @Override
    public String paymentError() {
        return "----- PaymentFallbackService fallback, wuwuwuwu paymentError";
    }
}
