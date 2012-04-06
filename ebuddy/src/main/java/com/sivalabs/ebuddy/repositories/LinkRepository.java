package com.sivalabs.ebuddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.ebuddy.entities.Link;

/**
 * @author skatam
 *
 */
public interface LinkRepository extends JpaRepository<Link, Integer>
{

}
