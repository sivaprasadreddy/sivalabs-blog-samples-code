/**
 * 
 */
package com.sivalabs.forum.web.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sivalabs.forum.entities.Category;
import com.sivalabs.forum.entities.ConfigParameter;
import com.sivalabs.forum.entities.Forum;

/**
 * @author Siva
 * 
 */
@Controller
public class AdminController extends BaseController {

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		return "admin/home";
	}

	@RequestMapping("/admin/categories")
	public String categories(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		if (page < 1) {
			page = 1;
		}
		Page<Category> categories = forumService.findCategories(page - 1);
		model.addAttribute("categoriesPage", categories);
		return "admin/categories";
	}

	@RequestMapping("/admin/categories/create")
	public String createCategory(Category c) {
		forumService.createCategory(c);
		return "redirect:/admin/categories";
	}

	@RequestMapping("/admin/forums")
	public String forums(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		if (page < 1) {
			page = 1;
		}
		Page<Forum> forumsPage = forumService.findForums(page - 1);
		model.addAttribute("forumsPage", forumsPage);

		List<Category> categories = forumService.findAllCategories();
		model.addAttribute("categories", categories);

		return "admin/forums";
	}

	@RequestMapping("/admin/forums/create")
	public String createForum(Forum forum) {
		forumService.createForum(forum);
		return "redirect:/admin/forums";
	}

	@RequestMapping("/admin/configuration")
	public String showConfiguration(Model model) {
		List<ConfigParameter> configParameters = forumService.findAllConfigParameters();
		model.addAttribute("configParameters",configParameters);
		return "admin/configuration";
	}
	
	@RequestMapping("/admin/configuration/create")
	public String createConfiguration(ConfigParameter configParameter) {
		forumService.createConfigParameter(configParameter);
		return "redirect:/admin/configuration";
	}
}
