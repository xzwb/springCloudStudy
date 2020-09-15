package cc.yyf.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class GatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      log.info("******** come in 全局过滤器  " + new Date());
      return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序,数字越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
