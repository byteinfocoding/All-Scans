package top.byteinfo.sceuritywebflux.componets;

import io.netty.util.CharsetUtil;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import reactor.core.publisher.Mono;
import top.byteinfo.sceuritywebflux.JacksonUtils;

import java.nio.charset.Charset;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
public class JsonServerAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {
    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        return WebFilterExchangeUtils.ExchangeResponseUtils(webFilterExchange, HttpStatus.OK, "登录成功!");


//        ServerHttpResponse serverHttpResponse = webFilterExchange.getExchange().getResponse();

//        serverHttpResponse.setStatusCode(HttpStatus.OK);
//        serverHttpResponse.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
//        String body = JacksonUtils.writeValueAsString("登录成功！");
//        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(body.getBytes(CharsetUtil.UTF_8));
//
////        String body = JacksonUtils.writeValueAsString(AjaxResult.ok("登录成功！"));
////        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(CharsetUtil.UTF_8));
//
////        DataBufferFactory dataBufferFactory = serverHttpResponse.bufferFactory();
////        DataBuffer buffer = dataBufferFactory.wrap(JacksonUtils.writeValueAsString("登录成功！").getBytes(Charset.defaultCharset()));
//        return serverHttpResponse.writeWith(Mono.just(buffer));
    }
}
