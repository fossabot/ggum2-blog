package net.ggum2.ggum2blog.service;

import net.ggum2.ggum2blog.domain.User;
import net.ggum2.ggum2blog.repository.entity.UserEntity;
import net.ggum2.ggum2blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOne(username);
        if (userEntity == null) {
            System.out.println("UserEntity does not exist.");
        }
        return new User(userEntity);
    }

}
