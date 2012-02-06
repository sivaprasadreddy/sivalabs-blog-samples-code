#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.dao.SampleDao;

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
		return "Welcome "+this.sampleDao.getDefaultUserGreeting()+"!!!";
	}
}
