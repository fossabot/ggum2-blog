package net.ggum2.ggum2blog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.ggum2.ggum2blog.domain.enums.Role;
import net.ggum2.ggum2blog.repository.entity.UserEntity;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Getter
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @NonNull
    private String username;

    private String password;

    private String name;

    private String nickname;

    @Builder.Default
    private Role role = Role.FRIEND;

    private Date created;

    private Date passwordUpdated;

    @Builder.Default
    private boolean isEnabled = false;

    @Builder.Default
    private boolean isAccountNonExpired = true;

    @Builder.Default
    private boolean isAccountNonLocked = true;

    @Builder.Default
    private boolean isCredentialsNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(this.role.toString());
    }

    @Builder
    public User(String username, String password, String name, String nickname, Role role, Date created, Date passwordUpdated, boolean isEnabled, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.role = role;
        this.created = created;
        this.passwordUpdated = passwordUpdated;
        this.isEnabled = isEnabled;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }
}
