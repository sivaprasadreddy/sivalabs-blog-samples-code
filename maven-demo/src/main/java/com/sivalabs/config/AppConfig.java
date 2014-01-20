package com.sivalabs.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

@Configuration
@ComponentScan(basePackages = { "com.sivalabs"}, excludeFilters={@Filter(pattern="com.sivalabs.web.*", type=FilterType.REGEX)})
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@EnableAsync
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig
{
	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${init-db:false}")
	private String initDB;

	@Bean
	public DataSourceInitializer dataSourceInitializer()
	{
		DataSourceInitializer dsInitializer = new DataSourceInitializer();
		dsInitializer.setDataSource(dataSource);
		String scripts = env.getProperty("scripts", "");
		logger.debug("Init-db :"+initDB+", scripts: "+scripts);
		if(Boolean.parseBoolean(initDB) && StringUtils.hasLength(scripts))
		{
			ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
			String[] files = scripts.split(",");
			for (String file : files) {
				databasePopulator.addScript(new ClassPathResource(file));
			}
			dsInitializer.setDatabasePopulator(databasePopulator);
		}
		
		return dsInitializer;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager()
	{
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	@Profile(value={"default","dev","prod"})
	public DataSource mysqlDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("mysql.jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("mysql.jdbc.url"));
		dataSource.setUsername(env.getProperty("mysql.jdbc.username"));
		dataSource.setPassword(env.getProperty("mysql.jdbc.password"));
		return dataSource;
	}
	/*
	@Bean
	@Profile(value={"test"})
	public DataSource hsqlDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("hsql.jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("hsql.jdbc.url"));
		dataSource.setUsername(env.getProperty("hsql.jdbc.username"));
		dataSource.setPassword(env.getProperty("hsql.jdbc.password"));
		return dataSource;
	}
	 */
	@Bean
	public CacheManager cacheManager()
	{
		return new ConcurrentMapCacheManager();
	}
	
}
