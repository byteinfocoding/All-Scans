package top.byteinfo.sceuritywebflux.repo;

import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import sun.security.util.Password;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
public class AccountInfoRepository {


    Mono<AuthUser> userDetailsMono = new Mono<AuthUser>() {

        @Override
        public void subscribe(CoreSubscriber coreSubscriber) {

        }
    };

    public Mono<AuthUser> findByUsername(String username){


        return userDetailsMono ;
    }


    public Mono<AuthUser> save(AuthUser authUser){
        return userDetailsMono ;

    }
}
