package top.byteinfo.sceuritywebflux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import top.byteinfo.sceuritywebflux.componets.*;

import java.util.LinkedList;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Autowired
    private AuthenticationConverter authenticationConverter;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private AuthEntryPointException serverAuthenticationEntryPoint;

    @Autowired
    private JsonServerAuthenticationSuccessHandler jsonServerAuthenticationSuccessHandler;

    @Autowired
    private JsonServerAuthenticationFailureHandler jsonServerAuthenticationFailureHandler;

    @Autowired
    private JsonServerLogoutSuccessHandler jsonServerLogoutSuccessHandler;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final String[] AUTH_WHITELIST = new String[]{"/login", "/logout"};


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
        SecurityWebFilterChain securityWebFilterChain = httpSecurity.formLogin()
                .loginPage("/login")
                // 登录成功handler
                .authenticationSuccessHandler(jsonServerAuthenticationSuccessHandler)
                // 登陆失败handler
                .authenticationFailureHandler(jsonServerAuthenticationFailureHandler)
                // 无访问权限handler
                .authenticationEntryPoint(serverAuthenticationEntryPoint)
                .and()
                .logout()
                // 登出成功handler
                .logoutSuccessHandler(jsonServerLogoutSuccessHandler)
                .and()
                .csrf().disable()
                .httpBasic().disable()
                .authorizeExchange()
                // 白名单放行
                .pathMatchers(AUTH_WHITELIST).permitAll()
                // 访问权限控制
                .anyExchange().access(authorizeConfigManager)
                .and().build();
        // 设置自定义登录参数转换器
        securityWebFilterChain.getWebFilters()
                .filter(webFilter -> webFilter instanceof AuthenticationWebFilter)
                .subscribe(webFilter -> {
                    AuthenticationWebFilter filter = (AuthenticationWebFilter) webFilter;
                    filter.setServerAuthenticationConverter(authenticationConverter);
                });

        return securityWebFilterChain;
    }
    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager() {
        LinkedList<ReactiveAuthenticationManager> managers = new LinkedList<>();
        managers.add(authenticationManager);
        return new DelegatingReactiveAuthenticationManager(managers);
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
