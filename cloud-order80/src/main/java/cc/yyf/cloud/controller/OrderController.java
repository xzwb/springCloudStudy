package cc.yyf.cloud.controller;

import cc.yyf.cloud.lb.LoadBalance;
import cc.yyf.cloud.pojo.Payment;
import cc.yyf.cloud.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
//    public static final String URL = "http://localhost:8001";

    public static final String URL = "http://CLOUD-PAYMENT-SERVICE";


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalance loadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public Result<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(URL+"/payment/create", payment, Result.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public String getPayment(@PathVariable("id") int id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() < 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/get/"+id, String.class);
//        return restTemplate.getForObject(URL+"/payment/get/"+id, Result.class);
    }
}
