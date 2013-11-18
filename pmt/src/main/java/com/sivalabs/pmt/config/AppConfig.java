package com.sivalabs.pmt.config;

import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Siva
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.sivalabs.pmt" }, 
				excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = WebPackageExcludeFilter.class)})
@PropertySource(value = {"classpath:application.properties" })
@MapperScan(basePackages="com.sivalabs.pmt.mappers")
public class AppConfig
{
	@Autowired
	private Environment env;

	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception 
    {
      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
      sqlSessionFactory.setDataSource(dataSource());
      sqlSessionFactory.setTypeAliasesPackage("com.sivalabs.pmt.entities");
      sqlSessionFactory.setTypeHandlersPackage("com.sivalabs.pmt.typehandlers");
      return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
	
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));

		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager()
	{
		PlatformTransactionManager txManager = new DataSourceTransactionManager(dataSource());
		return txManager;
	}

}

class WebPackageExcludeFilter extends RegexPatternTypeFilter
{

	public WebPackageExcludeFilter()
	{
		super(Pattern.compile("com\\.sivalabs\\.pmt\\.web\\..*"));
		
	}
	
}
