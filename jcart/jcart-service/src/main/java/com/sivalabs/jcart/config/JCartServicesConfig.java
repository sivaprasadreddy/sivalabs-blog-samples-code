package com.sivalabs.jcart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @author Siva
 *
 */
@Configuration
@Import(JCartPersistenceConfig.class)
public class JCartServicesConfig
{

}
