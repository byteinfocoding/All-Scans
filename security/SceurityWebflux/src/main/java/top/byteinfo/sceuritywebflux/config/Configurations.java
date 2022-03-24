package top.byteinfo.sceuritywebflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.byteinfo.sceuritywebflux.componets.*;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
@Configuration
public class Configurations {

    @Bean
    JsonServerAuthenticationSuccessHandler jsonServerAuthenticationSuccessHandler() {
        return new JsonServerAuthenticationSuccessHandler();
    }

    @Bean
    JsonServerAuthenticationFailureHandler jsonServerAuthenticationFailureHandler() {
        return new JsonServerAuthenticationFailureHandler();
    }

    @Bean
    JsonServerLogoutSuccessHandler jsonServerLogoutSuccessHandler() {
        return new JsonServerLogoutSuccessHandler();
    }

    @Bean
    AuthenticationConverter authenticationConverter() {
        return authenticationConverter();
    }

    @Bean
    AuthenticationManager authenticationManager() {
        return authenticationManager();
    }

    @Bean
    AuthEntryPointException authEntryPointException() {
        return authEntryPointException();
    }

    @Bean
    MySqlReactiveUserDetailsServiceImpl mySqlReactiveUserDetailsService() {
        return mySqlReactiveUserDetailsService();
    }

    @Bean
    AuthorizeConfigManager authorizeConfigManager() {
        return authorizeConfigManager();
    }
}
