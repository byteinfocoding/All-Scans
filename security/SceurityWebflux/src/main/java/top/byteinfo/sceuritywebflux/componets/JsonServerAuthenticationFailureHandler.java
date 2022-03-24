package top.byteinfo.sceuritywebflux.componets;

import io.netty.util.CharsetUtil;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import reactor.core.publisher.Mono;
import top.byteinfo.sceuritywebflux.JacksonUtils;

import java.nio.charset.Charset;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
public class JsonServerAuthenticationFailureHandler implements ServerAuthenticationFailureHandler {
    @Override
    public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException exception) {
        return WebFilterExchangeUtils.ExchangeResponseUtils(webFilterExchange, HttpStatus.OK, "登录失败");

//        ServerHttpResponse serverHttpResponse = webFilterExchange.getExchange().getResponse();
//        serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
//        serverHttpResponse.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
//        String body = JacksonUtils.writeValueAsString("登录失败！");
//        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(body.getBytes(CharsetUtil.UTF_8));
//        DataBufferFactory dataBufferFactory = serverHttpResponse.bufferFactory();
//        DataBuffer buffer = dataBufferFactory.wrap(JacksonUtils.writeValueAsString("登录失败！").getBytes(Charset.defaultCharset()));
//        return serverHttpResponse.writeWith(Mono.just(buffer));
    }
}
