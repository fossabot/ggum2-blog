package net.ggum2.ggum2blog.service;

import net.ggum2.ggum2blog.domain.Account;
import net.ggum2.ggum2blog.domain.AccountDetails;
import net.ggum2.ggum2blog.domain.enums.Role;
import net.ggum2.ggum2blog.repository.entity.UserEntity;
import net.ggum2.ggum2blog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findById(username);

        if (userEntity == null) {
            System.out.println("UserEntity does not exist.");
        }

        Account account = Account.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .nickname(userEntity.getNickname())
                .role(Role.valueOf(userEntity.getRole()))
                .enable(userEntity.isEnabled())
                .build();

        return new AccountDetails(account);
    }

    public boolean create(Account account) {
        String defaultRole = Role.FRIEND.toString();
        UserEntity userEntity = userRepository.save(UserEntity.builder()
                .id(account.getId())
                .password(bCryptPasswordEncoder.encode(account.getPassword()))
                .name(account.getName())
                .nickname(account.getNickname())
                .role(defaultRole)
                .build()
        );

        if (userEntity == null) {
            System.out.println("Signup Failed.");
            return false;
        }

        AccountDetails accountDetails = new AccountDetails(Account.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .nickname(userEntity.getNickname())
                .role(Role.valueOf(userEntity.getRole()))
                .enable(userEntity.isEnabled())
                .build());

        Authentication authentication = new UsernamePasswordAuthenticationToken(accountDetails, null, accountDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return true;
    }

}
