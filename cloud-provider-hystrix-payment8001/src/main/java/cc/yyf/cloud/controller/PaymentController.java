package cc.yyf.cloud.controller;

import cc.yyf.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/ok/{id}")
    public String paymentOK(@PathVariable("id") int id) {
        String result = paymentService.paymentInfoOk(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/timeout")
    public String paymentError() {
        return paymentService.Error(1);
    }

    // 熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") int id) {
        return paymentService.paymentCircuitBreaker(id);
    }

}
