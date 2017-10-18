package net.ggum2.ggum2blog;

import net.ggum2.ggum2blog.domain.enums.Role;
import net.ggum2.ggum2blog.repository.UserRepository;
import net.ggum2.ggum2blog.repository.entity.UserEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public InitializingBean createDevUsers() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return () -> {
            userRepository.save(UserEntity.builder()
                    .id("admin@ggum2.net")
                    .password(passwordEncoder.encode("P@ssw0rd"))
                    .name("Administrator")
                    .nickname("Administrator")
                    .role(Role.ADMIN.toString())
                    .enabled(true)
                    .build());
        };
    }
}
