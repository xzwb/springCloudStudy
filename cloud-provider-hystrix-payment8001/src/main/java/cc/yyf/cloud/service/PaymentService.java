package cc.yyf.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfoOk(int id) {
        return "线程池:  " + Thread.currentThread().getName() + "   paymentInfo_Ok" + id + "\t";
    }

    /**
     * 异常
     * 超时
     * 服务熔断触发服务降级
     * 线程池/信号量打满
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String Error(int id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "呜呜呜呜呜呜";
    }

    public String timeOutHandler(int id) {
        return "hahahahahahaha" + id;
    }

//     ======服务熔断
    // 10秒钟内10次访问60以上的失败率跳闸
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(int id) {
        if (id < 0) {
            throw new RuntimeException("********id不能为负数");
        }
        return "paymentCircuitBreaker   成功";
    }

    public String paymentCircuitBreakerFallBack(int id) {
        return "id不能为负数 wuwuwuwuwu";
    }
}
