package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.Category;

/**
 * @author Siva
 * 
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>
{


}
