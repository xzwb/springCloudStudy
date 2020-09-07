package cc.yyf.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义轮询算法
 */
public interface LoadBalance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
