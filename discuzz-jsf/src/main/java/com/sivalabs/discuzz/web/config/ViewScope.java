package com.sivalabs.discuzz.web.config;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.request.FacesRequestAttributes;

/**
 * From : http://blog.harezmi.com.tr/spring-view-scope-for-jsf-2-users/
 * @author K. Siva Prasad Reddy
 * Date : 01-Jul-2013
 */
public class ViewScope implements Scope
{
	public static final String VIEW_SCOPE_CALLBACKS = "viewScope.callbacks";

	public synchronized Object get(String name, ObjectFactory<?> objectFactory)
	{
		Map<String, Object> viewMap = getViewMap();
		Object instance = viewMap.get(name);
		if (instance == null) {
			instance = objectFactory.getObject();
			synchronized (viewMap) 
			{
				viewMap.put(name, instance);
			}
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public Object remove(String name)
	{
		Object instance = getViewMap().remove(name);
		if (instance != null)
		{
			Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
			if (callbacks != null)
			{
				callbacks.remove(name);
			}
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public void registerDestructionCallback(String name, Runnable runnable)
	{
		Map<String, Runnable> callbacks = (Map<String, Runnable>) getViewMap().get(VIEW_SCOPE_CALLBACKS);
		if (callbacks != null)
		{
			callbacks.put(name, runnable);
		}
	}

	public Object resolveContextualObject(String name)
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
		return facesRequestAttributes.resolveReference(name);
	}

	public String getConversationId()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesRequestAttributes facesRequestAttributes = new FacesRequestAttributes(facesContext);
		return facesRequestAttributes.getSessionId() + "-"+ facesContext.getViewRoot().getViewId();
	}

	private Map<String, Object> getViewMap()
	{
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap();
	}
}
