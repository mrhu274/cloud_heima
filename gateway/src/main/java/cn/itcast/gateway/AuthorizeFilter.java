package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * Created with IntelliJ IDEA.
 * User: hhp
 * Date: 2022/6/3
 * Time: 15:51
 * Description: No Description
 */
@Component
//@Order(-1)
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //获取请求参数中的authorization参数
        String authorization = queryParams.getFirst("authorization");
        //判断authorization参数
        if (authorization.equals("admin")) {
            //放行
            return chain.filter(exchange);

        }
        //设置响应状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //拒绝访问
        return exchange.getResponse().setComplete();
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
