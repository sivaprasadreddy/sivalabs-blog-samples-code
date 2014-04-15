/**
 * 
 */
package com.sivalabs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Siva
 *
 */
@ConfigurationProperties()
public class AppProperties {
	
	private String greeting;
	
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
