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
    public String Error() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "呜呜呜呜呜呜";
    }

    public String timeOutHandler() {
        return "hahahahahahaha";
    }
}
