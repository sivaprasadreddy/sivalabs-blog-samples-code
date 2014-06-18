/**
 * 
 */
package com.sivalabs.springapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Siva
 *
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) 
//@ImportResource("classpath:applicationContext-security.xml")
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		/*
        registry
        .inMemoryAuthentication()
        .withUser("siva")  // #1
          .password("siva")
          .roles("USER")
          .and()
        .withUser("admin") // #2
          .password("admin")
          .roles("ADMIN","USER");
        */
        
       // registry.jdbcAuthentication().dataSource(dataSource);
		registry.userDetailsService(customUserDetailsService);
    }


	  @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/app/resources/**"); // #3
	  }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	    .csrf().disable()
	    .authorizeRequests()
	        .antMatchers("/app/login","/app/login/form**","/app/register","/app/logout").permitAll() // #4
	        .antMatchers("/app/admin","/app/admin/**").hasRole("ADMIN") // #6
	        .anyRequest().authenticated() // 7
	        .and()
	    .formLogin()  // #8
	        .loginPage("/app/login/form") // #9
	        .loginProcessingUrl("/app/login")
	        .failureUrl("/app/login/form?error")
	        .permitAll() // #5
	        .and()
	     .logout()
	     	.logoutUrl("/app/logout");
	  }
}
