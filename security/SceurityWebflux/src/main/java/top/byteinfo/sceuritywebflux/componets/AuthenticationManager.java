package top.byteinfo.sceuritywebflux.componets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
public class AuthenticationManager extends AbstractUserDetailsReactiveAuthenticationManager {
    private Scheduler scheduler = Schedulers.boundedElastic();

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private MySqlReactiveUserDetailsServiceImpl mySqlReactiveUserDetailsService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        AuthenticationToken token = (AuthenticationToken) authentication;
        final String username = authentication.getName();
        final String presentedPassword = (String) authentication.getCredentials();
        final String tenant = token.getTenant();
        final String host = token.getHost();

        return retrieveUser(username)
                .publishOn(scheduler)
                .filter(u -> passwordEncoder.matches(presentedPassword, u.getPassword()))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new BadCredentialsException("Invalid Credentials"))))
                .flatMap(u -> {
                    boolean upgradeEncoding = mySqlReactiveUserDetailsService != null
                            && passwordEncoder.upgradeEncoding(u.getPassword());
                    if (upgradeEncoding) {
                        String newPassword = passwordEncoder.encode(presentedPassword);
                        return mySqlReactiveUserDetailsService.updatePassword(u, newPassword);
                    }
                    return Mono.just(u);
                })
                .flatMap(userDetails -> {
                    // 省略业务代码
                    return Mono.just(userDetails);
                })
                .map(u -> new AuthenticationToken(u, u.getPassword(), u.getAuthorities()));


    }


    @Override
    protected Mono<UserDetails> retrieveUser(String username) {
        return mySqlReactiveUserDetailsService.findByUsername(username);
    }
}
