package org.hathor.Hathor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("nicolas").password("password").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("jeff").password("password").roles("SUP");
//	}

	//Security for all API

	//	@Override
	//	protected void configure(HttpSecurity http) throws Exception {
	//		http.csrf().disable();
	//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	//	}

	//security based on URL
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors();
			http.csrf().disable();
			http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
		}

	//security based on role
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
//	}

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
	}
}