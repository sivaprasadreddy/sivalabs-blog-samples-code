package com.sivalabs.forum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.Post;

/**
 * @author Siva
 * 
 */
public interface PostRepository extends JpaRepository<Post, Integer>
{

	List<Post> findPostsByTopicId(int topicId);


}
