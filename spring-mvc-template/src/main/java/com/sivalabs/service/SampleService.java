/**
 * 
 */
package com.sivalabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.dao.SampleDao;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class SampleService 
{
	@Autowired
	private SampleDao sampleDao;
	
	public String getDefaultUserGreeting() 
	{
		return this.sampleDao.getDefaultUserGreeting();
	}
}
