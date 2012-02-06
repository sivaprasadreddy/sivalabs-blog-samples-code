/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.core.web.customtags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author K. Siva Prasad Reddy
 * Date : Aug 6, 2011
 */
public class BaseTag extends TagSupport
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doStartTag() throws JspException
	{
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException
	{		
		return EVAL_PAGE;
	}
	
	public static String getAbsolutePath(PageContext pageContext, String path)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		return  getAbsolutePath(request, path);
	}
	
	public static String getAbsolutePath(HttpServletRequest request, String path)
	{
		String contextRoot = request.getContextPath();
		String cleanPath = stripStartingChars(path, '/');
		return (contextRoot+"/"+cleanPath);
	}
	
	public static String getRelativePath(PageContext pageContext, String path)
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		return  getRelativePath(request, path);
	}
	
	public static String getRelativePath(HttpServletRequest request, String path)
	{
		//String contextRoot = request.getContextPath();
		String uri = request.getRequestURI();
		//StringBuffer url = request.getRequestURL();
		//System.out.println(uri);
		//System.out.println(url);
		String cleanPath = uri.substring(0, uri.lastIndexOf('/'));
		return (cleanPath+path);
	}
	
	public static String stripStartingChars(String str, char c)
	{
		int len = str.length();
		for (int i = 0; i < len; i++)
		{
			if(str.charAt(i) != c)
			{
				return str.substring(i);
			}
		}
		return str;
	}
}
