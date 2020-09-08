package cc.yyf.cloud.controller;

import cc.yyf.cloud.pojo.Payment;
import cc.yyf.cloud.pojo.Result;
import cc.yyf.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public Result create(@RequestBody Payment payment) {
        Result result = paymentService.create(payment);
        log.info("*****插入结果" + result);
        return result;
    }

    @GetMapping("/payment/get/{id}")
    public Result select(@PathVariable("id") int id) {
        Result result = paymentService.getPaymentById(id);
        log.info("******查询" + result + "  serverPort : " + serverPort);
        return result;
    }

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
