package net.ggum2.ggum2blog.domain;

import net.ggum2.ggum2blog.repository.entity.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;

public class User extends org.springframework.security.core.userdetails.User {

    private final UserEntity userEntity;

    public User(UserEntity userEntity) {
        super(userEntity.getUsername(), userEntity.getPassword(), AuthorityUtils.createAuthorityList(userEntity.getRole().toString()));
        this.userEntity = userEntity;
    }
}
