package top.byteinfo.sceuritywebflux.componets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.byteinfo.sceuritywebflux.JacksonUtils;

import java.util.Collection;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
@Slf4j
public class AuthorizeConfigManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext authorizationContext) {

        return authentication.map(auth -> {
            ServerWebExchange exchange = authorizationContext.getExchange();
            ServerHttpRequest request = exchange.getRequest();

            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                String authorityAuthority = authority.getAuthority();
                String path = request.getURI().getPath();
                if (antPathMatcher.match(authorityAuthority, path)) {
                    log.info(String.format("用户请求API校验通过，GrantedAuthority:{%s}  Path:{%s} ", authorityAuthority, path));
                    return new AuthorizationDecision(true);
                }
            }
            return new AuthorizationDecision(false);
        }).defaultIfEmpty(new AuthorizationDecision(false));

    }


    @Override
    public Mono<Void> verify(Mono<Authentication> authentication, AuthorizationContext object) {
        return check(authentication, object)
                .filter(d -> d.isGranted())
                .switchIfEmpty(Mono.defer(() -> {
//                    AjaxResult<String> ajaxResult = AjaxResult.restResult("当前用户没有访问权限! ", ApiErrorCode.FAILED);
//                    String body = JSONObject.toJSONString(ajaxResult);

                    String body = JacksonUtils.writeValueAsString("当前用户没有访问权限! ");
                    return Mono.error(new AccessDeniedException(body));
                }))
                .flatMap(d -> Mono.empty());
    }

}
