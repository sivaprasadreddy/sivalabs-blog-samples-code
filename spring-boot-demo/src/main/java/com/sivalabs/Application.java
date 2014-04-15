/**
 * 
 */
package com.sivalabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sivalabs.config.AppProperties;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties(AppProperties.class)
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	
}
