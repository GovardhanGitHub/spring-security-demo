package com.example.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.eraseCredentials(true)
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	}

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
        	.antMatchers(HttpMethod.POST,"/auth/signUp").permitAll();
        	
        http.authorizeRequests()
        	.antMatchers(HttpMethod.GET,"/api/**").hasAnyRole("ADMIN", "MANAGER")
            .antMatchers(HttpMethod.PUT,"/api/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE,"/api/**").hasRole("SUPER_ADMIN")
            .anyRequest().authenticated()
        .and().httpBasic()
        .and().headers().frameOptions().disable();
		}

}