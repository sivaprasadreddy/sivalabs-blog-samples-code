package com.sivalabs.pmt.config

import javax.annotation.PostConstruct
import javax.sql.DataSource

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

/**
 * @author Siva
 *
 */
@Component
public class DBInit
{
	
	@Autowired Environment env;
	@Autowired DataSource dataSource;
	
	@PostConstruct
	public void init()
	{
		String initDb=env.getProperty("init-db", "false");
		System.err.println("initDb :"+initDb);
		if(Boolean.valueOf(initDb))
		{
			ScriptRunner scriptRunner = new ScriptRunner(dataSource.getConnection());
			Reader reader = Resources.getResourceAsReader("sql/pmt_db_mysql.sql");
			scriptRunner.runScript(reader);
		}
	}

}
