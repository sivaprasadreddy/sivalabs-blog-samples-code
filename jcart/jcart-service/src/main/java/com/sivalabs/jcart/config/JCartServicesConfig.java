package com.sivalabs.jcart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author Siva
 *
 */
@Configuration
@EnableScheduling
@Import(JCartPersistenceConfig.class)
public class JCartServicesConfig
{

}
