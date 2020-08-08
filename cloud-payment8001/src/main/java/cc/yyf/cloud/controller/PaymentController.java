package cc.yyf.cloud.controller;

import cc.yyf.cloud.pojo.Payment;
import cc.yyf.cloud.pojo.Result;
import cc.yyf.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public Result create(@RequestBody Payment payment) {
        Result result = paymentService.create(payment);
        log.info("*****插入结果" + result);
        return result;
    }

    @GetMapping("/payment/get/{id}")
    public Result select(@PathVariable("id") int id) {
        Result result = paymentService.getPaymentById(id);
        log.info("******查询" + result);
        return result;
    }
}
