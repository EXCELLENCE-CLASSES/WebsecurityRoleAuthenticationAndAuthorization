package com.excellence.OnlineOfficialWebsite;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter 
{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		
		System.out.println("hello");
		
		
		// TODO Auto-generated method stub
		
		auth.inMemoryAuthentication().withUser("EXC").password("ARYA").roles("USER").
		and()
		.withUser("EXCELLENCE").password("ARYA").roles("ADMIN");
		
		
		
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncorder() 
	{
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//user can make any kind of authentication
		//http.authorizeRequests().antMatchers("/","static/css","static/js").permitAll().
		// antMatchers("/**").hasRole("ADMIN").and().formLogin();
		//or
		http.authorizeRequests()
		
	
		.antMatchers("/User").hasRole("User")
		//Admin should have both ,user role as well as admin role
		.antMatchers("/Admin").hasAnyRole("Admin","User")
		.antMatchers("/").permitAll()		
		.and()
		.formLogin();
		
		
	}
	
	
	
	
	
	

}
