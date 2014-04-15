/**
 * 
 */
package sivalabs.app.core.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static final Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Value("${init-db:false}")
	private String initDatabase;
	
	@Autowired 
	private DataSource dataSource;
	
	//@Bean
	public DataSourceInitializer dataSourceInitializer()
	{
		logger.info("############## InitDatabase :" + initDatabase + " ########################");
		
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("mysql.sql"));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
		return dataSourceInitializer;
	}
	
}
