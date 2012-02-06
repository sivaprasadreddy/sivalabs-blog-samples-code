/**
 * This software is developed by the author of http://sivalabs.blogspot.com
 * It is a freeware, you can use it, change it, redistribute.
 */
package com.sivalabs.core.web.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;

/**
 * @author K. Siva Prasad Reddy
 * Date : Aug 6, 2011 
 */
public class IncludeResourceTag extends BaseTag
{
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String path;
	
	
	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			String absolutePath = getAbsolutePath(pageContext, this.path);
			String text = "";
			
			if("js".equalsIgnoreCase(type) || "javascript".equalsIgnoreCase(type))
			{
				text = "<script type=\"text/javascript\" src=\""+absolutePath+"\"></script>";
			} 
			else if("css".equalsIgnoreCase(type) || "stylesheet".equalsIgnoreCase(type))
			{
				text = "<LINK href=\""+absolutePath+"\" rel=\"stylesheet\" type=\"text/css\">";
			}
			
			pageContext.getOut().write(text);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}
	
}
