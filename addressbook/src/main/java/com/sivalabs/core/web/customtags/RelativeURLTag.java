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
public class RelativeURLTag extends BaseTag
{
	private static final long serialVersionUID = 1L;
	
	private String path;
	
	@Override
	public int doStartTag() throws JspException
	{
		try
		{
			String absolutePath = getRelativePath(pageContext, this.path);
			pageContext.getOut().print(absolutePath);
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
	
}
