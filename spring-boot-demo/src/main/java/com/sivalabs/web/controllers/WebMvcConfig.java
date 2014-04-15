/**
 * 
 */
package com.sivalabs.web.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Siva
 *
 */
@Controller
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebMvcConfig extends WebMvcConfigurerAdapter 
{

	@RequestMapping("/")
	String welcome() {
		return "index";
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}

	@Order(Ordered.LOWEST_PRECEDENCE - 8)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// @formatter:off
			auth.inMemoryAuthentication().withUser("admin").password("admin")
					.roles("ADMIN", "USER").and().withUser("user").password("user")
					.roles("USER");
			// @formatter:on
		}
		
		@Override
		  public void configure(WebSecurity web) throws Exception {
		    web
		      .ignoring()
		         .antMatchers("/resources/**")
		         .antMatchers("/webjars/**");
		  }
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
			.fullyAuthenticated().and().formLogin().loginPage("/login")
			.failureUrl("/login?error").and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
			.exceptionHandling().accessDeniedPage("/access?error");
		}
	}
}
