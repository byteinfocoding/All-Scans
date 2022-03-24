package top.byteinfo.sceuritywebflux.componets;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author coding
 * Created by coding on 2022/3/23
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class AuthenticationToken extends UsernamePasswordAuthenticationToken {
    private String tenant;

    private String host;

    public AuthenticationToken(Object principal, Object credentials, String tenant, String host) {
        super(principal, credentials);
        this.tenant = tenant;
        this.host = host;
    }
    public AuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public AuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
