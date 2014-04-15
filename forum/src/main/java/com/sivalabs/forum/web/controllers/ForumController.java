/**
 * 
 */
package com.sivalabs.forum.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sivalabs.forum.entities.Category;
import com.sivalabs.forum.entities.Forum;
import com.sivalabs.forum.entities.Post;
import com.sivalabs.forum.entities.Topic;

/**
 * @author Siva
 *
 */
@Controller
public class ForumController extends BaseController
{

	@RequestMapping("/home")
	public String welcome(Model model) {
		List<Category> categories = forumService.findAllCategories();
		model.addAttribute("categories", categories);
		return "user/home";
	}
	
	@RequestMapping("/forums/{id}")
	public String showForum(@PathVariable(value="id") int forumId, Model model) {
		
		Forum forum = forumService.findForum(forumId);
		model.addAttribute("forum", forum);
		return "user/forum";
	}
	
	@RequestMapping("/topics/{id}")
	public String topics(@PathVariable(value="id") int topicId, Model model) {
		
		Topic topic = forumService.findTopic(topicId);
		model.addAttribute("topic", topic);
		return "user/topic";
	}
	
	@RequestMapping("/topics/new")
	public String topicForm(@RequestParam(value="forumId") int forumId, Model model) {
		
		Topic topic = new Topic();
		topic.setForum(forumService.findForum(forumId));
		model.addAttribute("topic", topic);
		return "user/createTopic";
	}
	
	@RequestMapping("/topics/create")
	public String topicForm(Post post, Model model, HttpSession session) {
		
		post.setCreatedBy(getCurrentUser(session));
		Topic topic = post.getTopic();
		topic.setTitle(post.getTitle());
		topic.setCreatedBy(post.getCreatedBy());
		topic.getPosts().add(post);
		topic.setLastPost(post);
		Topic savedTopic = forumService.createTopic(topic);
		
		return "redirect:/topics/"+savedTopic.getId();
	}
	
	
	@RequestMapping("/topics/{topicId}/reply")
	public String topicReplyForm(@PathVariable(value="topicId") int topicId, Model model) {
		
		Topic topic = forumService.findTopic(topicId);
		Post post = new Post();
		post.setTopic(topic);
		post.setTitle(topic.getTitle());
		model.addAttribute("post", post);
		return "user/createPost";
	}
	
	@RequestMapping("/topics/{topicId}/postReply")
	public String createPost(@PathVariable(value="topicId") int topicId, Post post, Model model, HttpSession session) {
		Topic topic = forumService.findTopic(topicId);
		post.setTopic(topic);
		post.setCreatedBy(getCurrentUser(session));
		Post savedPost = forumService.createPost(post);
		System.err.println(savedPost);
		return "redirect:/topics/"+topic.getId();
	}
}
