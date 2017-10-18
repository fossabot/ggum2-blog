package net.ggum2.ggum2blog.domain;


import lombok.Getter;
import net.ggum2.ggum2blog.domain.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by hyunsoo0813 on 2017. 10. 17..
 */
public class AccountDetails extends org.springframework.security.core.userdetails.User{

    @Getter
    private String id;

    @Getter
    private String nickname;

    @Getter
    private String role;

    public AccountDetails(Account account) {
        super(account.getId(), account.getPassword(), authorities(account.getRole()));
        this.id = account.getId();
        this.nickname = account.getNickname();
        this.role = account.getRole().toString();
    }

    private static Collection<? extends GrantedAuthority> authorities(Role role) {
        return AuthorityUtils.createAuthorityList(role.toString());
    }

}
