package com.sivalabs.ssdemo.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
//import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sivalabs.ssdemo.config.AppConfig;
import com.sivalabs.ssdemo.config.SecurityConfig;

/**
 * @author Siva
 * 
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class<?>[] { AppConfig.class /*, SecurityConfig.class */};
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
	
	//Instead we used SecurityWebApplicationInitializer
	
	@Override
    protected Filter[] getServletFilters() {
       return new Filter[]{
    		   new OpenEntityManagerInViewFilter()
    		   //new DelegatingFilterProxy("springSecurityFilterChain")
    		   };
    } 
	
	/*
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
		FilterRegistration.Dynamic reg =
				servletContext.addFilter("SiteMeshFilter",
				"com.opensymphony.sitemesh.webapp.SiteMeshFilter");
		EnumSet<DispatcherType> disps = EnumSet.of(
                DispatcherType.REQUEST, DispatcherType.FORWARD);
				reg.addMappingForUrlPatterns(disps, true, "/*");
	}
	*/

}
