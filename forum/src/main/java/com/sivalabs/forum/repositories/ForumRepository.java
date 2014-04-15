package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.Forum;

/**
 * @author Siva
 * 
 */
public interface ForumRepository extends JpaRepository<Forum, Integer>
{


}
