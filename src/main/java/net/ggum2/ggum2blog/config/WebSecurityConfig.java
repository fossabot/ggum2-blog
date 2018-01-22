package net.ggum2.ggum2blog.config;

import lombok.extern.slf4j.Slf4j;
import net.ggum2.ggum2blog.config.interceptor.CustomWebSecurityFilter;
import net.ggum2.ggum2blog.domain.enums.Role;
import net.ggum2.ggum2blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.sql.DataSource;

@Slf4j
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Autowired
    private UserDetailsService userDetailsService;

	@Autowired
    private LoginService loginService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/color_material/**", "/custom/**", "/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/signup").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and()
			.addFilterAfter(new CustomWebSecurityFilter(), BasicAuthenticationFilter.class)
			.httpBasic();

		http.csrf().ignoringAntMatchers("/h2-console/**");

		// spring security configurations for h2 database
		// https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
		for (String profile : environment.getActiveProfiles()) {
			if (profile.equals("dev")) {
				http.headers().frameOptions().disable();
			} else {
				http.headers().frameOptions().sameOrigin();
			}
		}

	}

    @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

}
