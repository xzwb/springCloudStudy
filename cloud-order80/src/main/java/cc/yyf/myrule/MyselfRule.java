package cc.yyf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡算法: rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标,
 * 每次服务重启动后rest接口计数从1开始
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule iRule() {
        return new RandomRule(); // 随机
    }
}
