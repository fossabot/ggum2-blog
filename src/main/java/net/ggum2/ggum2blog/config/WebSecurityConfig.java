package net.ggum2.ggum2blog.config;

import lombok.extern.slf4j.Slf4j;
import net.ggum2.ggum2blog.config.interceptor.CustomWebSecurityFilter;
import net.ggum2.ggum2blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Slf4j
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/unify/**", "/custom/**");
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

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user@ggum2.net").password("P@ssw0rd").roles("USER")
				.and()
				.withUser("admin_mem@ggum2.net").password("P@ssw0rd").roles("USER", "ADMIN");
	}

	@Configuration
	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

		@Autowired
		private LoginService loginService;

		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(loginService).passwordEncoder(bCryptPasswordEncoder());
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
		}
	}

}
