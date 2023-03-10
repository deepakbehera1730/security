package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService  userDetailsService;
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//	 List<UserDetails> users=new ArrayList<>();
//	 
//	 users.add(User.withDefaultPasswordEncoder().username("Deepak").password("Deepak26@").roles("Normal").build());
//	 users.add(User.withDefaultPasswordEncoder().username("Suraj").password("Suraj26@").roles("Admin").build());
//	 return new InMemoryUserDetailsManager(users);
//	}

	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
}
