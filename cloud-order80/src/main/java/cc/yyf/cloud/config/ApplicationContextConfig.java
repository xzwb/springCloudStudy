package cc.yyf.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
//    注释掉手写负载均衡算法
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
