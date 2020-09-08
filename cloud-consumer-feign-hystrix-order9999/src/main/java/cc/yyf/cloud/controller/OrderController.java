package cc.yyf.cloud.controller;

import cc.yyf.cloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/ok/{id}")
    public String ok(@PathVariable("id") int id) {
        return orderService.paymentOK(id);
    }

    @GetMapping("/error/ss")
    @HystrixCommand(fallbackMethod = "orderTimeOutFallBackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String error() {
        return orderService.paymentError();
    }

    public String orderTimeOutFallBackMethod() {
        return "我是傻逼9999,我挂了";
    }
}
