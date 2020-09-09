package cc.yyf.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface OrderService {

    @GetMapping("/payment/ok/{id}")
    public String paymentOK(@PathVariable("id") int id);

    @GetMapping("/payment/timeout")
    public String paymentError();

}
