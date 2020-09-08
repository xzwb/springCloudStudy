package cc.yyf.cloud.service;

import cc.yyf.cloud.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("/payment/get/{id}")
    public Result select(@PathVariable("id") int id);

    @GetMapping("/payment/timeout")
    public String paymentFeignTimeOut();
}
