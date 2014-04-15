/**
 * 
 */
package com.sivalabs.phonebook.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author katsi02
 *
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware 
{
	private static ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;		
	}
	
	public static <T> T getBean(Class<T> type) 
	{
		return ctx.getBean(type);
	}

	public static <T> T getBean(String beanId, Class<T> type) 
	{
		return ctx.getBean(beanId, type);
	}
	
}
