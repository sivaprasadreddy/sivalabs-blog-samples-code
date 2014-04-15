package com.sivalabs.bookstore.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sivalabs.bookstore.config.AppConfig;

/**
 * @author Siva
 * 
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class<?>[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class<?>[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

}
