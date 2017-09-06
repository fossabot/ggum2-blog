package net.ggum2.ggum2blog.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by hyunsoo0813 on 2017. 9. 6..
 */
public class User  implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public static enum Role {
        ADMIN, FAMILY, FRIEND, ANONYMOUS
    }

    private String id;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    private boolean isEnabled;
}
