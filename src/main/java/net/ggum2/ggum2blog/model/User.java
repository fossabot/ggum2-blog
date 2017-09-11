package net.ggum2.ggum2blog.model;

import net.ggum2.ggum2blog.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * Created by hyunsoo0813 on 2017. 9. 6..
 */
public class User {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    private boolean isEnabled;

    private Date created;

}
