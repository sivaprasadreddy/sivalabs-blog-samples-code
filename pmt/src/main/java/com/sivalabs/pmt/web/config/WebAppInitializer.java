package com.sivalabs.pmt.web.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sivalabs.pmt.config.AppConfig;

public class WebAppInitializer extends  AbstractAnnotationConfigDispatcherServletInitializer 
{

	  @Override
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class<?>[] { AppConfig.class };
	  }

	  @Override
	  protected Class<?>[] getServletConfigClasses() {
	    return new Class<?>[] { WebMvcConfig.class };
	  }

	  @Override
	  protected String[] getServletMappings() {
	    return new String[]{ "/"};
	  }

	  @Override
	  protected Filter[] getServletFilters() {

	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setEncoding("UTF-8");
	    return new Filter[]{ characterEncodingFilter} ;
	  }
	  
	  
}