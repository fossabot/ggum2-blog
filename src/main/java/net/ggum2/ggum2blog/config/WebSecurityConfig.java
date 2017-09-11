package net.ggum2.ggum2blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/unify/**", "/custom/**").permitAll()		// Static Files
				.antMatchers("/admin/**").hasRole("ADMIN")				// Admin Pages
				.antMatchers("/h2-console/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.and()
			.httpBasic();

		http.csrf().ignoringAntMatchers("/h2-console/**");

		// spring security configurations for h2 database
		// https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/
		for (String profile : environment.getActiveProfiles()) {
			if (profile.equals("dev")) {
				http.headers().frameOptions().disable();
			}
		}

	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user@ggum2.net").password("P@ssw0rd").roles("USER")
				.and()
				.withUser("admin@ggum2.net").password("P@ssw0rd").roles("USER", "ADMIN");
	}
}
