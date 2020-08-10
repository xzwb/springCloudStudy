package cc.yyf.cloud.controller;

import cc.yyf.cloud.pojo.Payment;
import cc.yyf.cloud.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
//    public static final String URL = "http://localhost:8001";

    public static final String URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public Result<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(URL+"/payment/create", payment, Result.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public Result<Payment> getPayment(@PathVariable("id") int id) {
        return restTemplate.getForObject(URL+"/payment/get/"+id, Result.class);
    }
}
