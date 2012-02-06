/**
 * 
 */
package org.sivalabs.portal.web.controllers;

import java.io.IOException;

//import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sivalabs.portal.bo.IEchoService;
import org.sivalabs.portal.core.utils.JNDIUtils;
import org.sivalabs.portal.core.utils.StringUtils;

/**
 * @author skatam
 *
 */
public class EchoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	//@EJB
	private IEchoService echoService;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
		echoService = JNDIUtils.lookup("corporate-portal/EchoServiceBean/remote", IEchoService.class);
		String username = req.getParameter("username");
		if(StringUtils.isEmpty(username)){
			username = "Guest";
		}
		String echo = echoService.echo(username);
		req.setAttribute("ECHO", echo);
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
