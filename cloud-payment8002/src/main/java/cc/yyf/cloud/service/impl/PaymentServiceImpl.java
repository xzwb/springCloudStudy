package cc.yyf.cloud.service.impl;

import cc.yyf.cloud.mapper.PaymentMapper;
import cc.yyf.cloud.pojo.Payment;
import cc.yyf.cloud.pojo.Result;
import cc.yyf.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Result create(Payment payment) {
        paymentMapper.create(payment);
        return new Result<Payment>(200, "成功", payment);
    }

    @Override
    public Result getPaymentById(int id) {
        Payment payment = paymentMapper.getPaymentById(id);
        return new Result<Payment>(200, "成功", payment);
    }
}
