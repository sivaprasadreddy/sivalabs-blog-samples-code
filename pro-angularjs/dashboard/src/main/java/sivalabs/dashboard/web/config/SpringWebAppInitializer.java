package sivalabs.dashboard.web.config;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
//import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import sivalabs.dashboard.config.AppConfig;

//import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

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
	
	//Instead we used SecurityWebApplicationInitializer
	
	@Override
    protected Filter[] getServletFilters() {
		//SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
		
       return new Filter[]{
	    		   //new DelegatingFilterProxy("springSecurityFilterChain")
	    		   new OpenEntityManagerInViewFilter(),
	    		   new HttpPutFormContentFilter()
	    		  // new SiteMeshFilter()
    		   };
    } 
	
	

}
