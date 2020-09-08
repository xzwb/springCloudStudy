package cc.yyf.cloud.controller;

import cc.yyf.cloud.pojo.Result;
import cc.yyf.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public Result getPaymentId(@PathVariable("id") int id) {
        return paymentService.select(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeOut() {
        return paymentService.paymentFeignTimeOut();
    }
}
