package cc.yyf.cloud.service;

import cc.yyf.cloud.pojo.Payment;
import cc.yyf.cloud.pojo.Result;

public interface PaymentService {
    Result create(Payment payment);

    Result getPaymentById(int id);
}
