/**
 * 
 */
package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.Category;
import com.sivalabs.forum.entities.ConfigParameter;
import com.sivalabs.forum.entities.Forum;
import com.sivalabs.forum.entities.Post;
import com.sivalabs.forum.entities.Topic;
import com.sivalabs.forum.repositories.CategoryRepository;
import com.sivalabs.forum.repositories.ConfigParameterRepository;
import com.sivalabs.forum.repositories.ForumRepository;
import com.sivalabs.forum.repositories.PostRepository;
import com.sivalabs.forum.repositories.TopicRepository;
import com.sivalabs.forum.repositories.UserRepository;
import com.sivalabs.forum.utils.Constants;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class ForumService {

	
	
	@Autowired private UserRepository userRepository;
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ForumRepository forumRepository;
	@Autowired private TopicRepository topicRepository;
	@Autowired private PostRepository postRepository;
	@Autowired private ConfigParameterRepository configParameterRepository;
	
	
	/***************************** Category operations **********************************/
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Page<Category> findCategories(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, Constants.PAGE_SIZE);
		Page<Category> categoriesPage = categoryRepository.findAll(pageRequest);
		return categoriesPage;
	}
	
	
	/********************************** Forum operations **********************************/
	public Forum findForum(int id) {
		return forumRepository.findOne(id);
	}
	public List<Forum> findAllForums() {
		return forumRepository.findAll();
	}
	public Page<Forum> findForums(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, Constants.PAGE_SIZE);
		Page<Forum> forumsPage = forumRepository.findAll(pageRequest);
		return forumsPage;
	}
	public Forum createForum(Forum forum) {
		return forumRepository.save(forum);
	}
	
	
	
	/********************************** Topic operations **********************************/
	public Topic findTopic(int topicId) {
		return topicRepository.findOne(topicId);
	}
	public List<Topic> findTopics(int forumId){
		return topicRepository.findTopicsByForumId(forumId);
	}
	
	public Topic createTopic(Topic topic) {
		return topicRepository.save(topic);
	}
	
	/********************************** Post operations **********************************/
	
	public List<Post> findPosts(int topicId) {
		return postRepository.findPostsByTopicId(topicId);
	}
	
	public Post createPost(Post post) {
		Topic topic = topicRepository.findOne(post.getTopic().getId());
		topic.setLastPost(post);
		return postRepository.save(post);
	}
	

	/***************************** ConfigParameter operations **********************************/
	public List<ConfigParameter> findAllConfigParameters() {
		return configParameterRepository.findAll();
	}

	public void createConfigParameter(ConfigParameter configParameter) {
		configParameterRepository.save(configParameter);
	}
	
	
}
