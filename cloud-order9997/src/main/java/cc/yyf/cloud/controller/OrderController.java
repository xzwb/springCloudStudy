package cc.yyf.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    public static final String URL = "http://consul-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String payment() {
        String result = restTemplate.getForObject(URL+"/consul/payment", String.class);
        return result;
    }
}
