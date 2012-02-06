/**
 * 
 */
package com.sivalabs.addressbook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author skatam
 *
 */
@Controller
public class PageController
{
	@RequestMapping("page")
	public ModelAndView welcome(@RequestParam("view") String view)
	{
		return new ModelAndView(view);
	}
}
