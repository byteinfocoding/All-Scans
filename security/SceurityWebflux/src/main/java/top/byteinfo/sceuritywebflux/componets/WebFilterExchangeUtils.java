package top.byteinfo.sceuritywebflux.componets;

import io.netty.util.CharsetUtil;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.web.server.WebFilterExchange;
import reactor.core.publisher.Mono;
import top.byteinfo.sceuritywebflux.JacksonUtils;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
public class WebFilterExchangeUtils {

    public static Mono<Void> ExchangeResponseUtils(WebFilterExchange webFilterExchange ,HttpStatus HttpStatusCode, String Body ){

        ServerHttpResponse serverHttpResponse = webFilterExchange.getExchange().getResponse();
        serverHttpResponse.setStatusCode(HttpStatusCode);
        serverHttpResponse.getHeaders().set(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        String body = JacksonUtils.writeValueAsString(Body);
        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(body.getBytes(CharsetUtil.UTF_8));

//        String body = JacksonUtils.writeValueAsString(AjaxResult.ok("登录成功！"));
//        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(CharsetUtil.UTF_8));

//        DataBufferFactory dataBufferFactory = serverHttpResponse.bufferFactory();
//        DataBuffer buffer = dataBufferFactory.wrap(JacksonUtils.writeValueAsString("登录成功！").getBytes(Charset.defaultCharset()));
        return serverHttpResponse.writeWith(Mono.just(buffer));

    }
}
