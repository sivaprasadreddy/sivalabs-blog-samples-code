/**
 * 
 */
package com.sivalabs.springmvc.tests;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author siva
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException 
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}
