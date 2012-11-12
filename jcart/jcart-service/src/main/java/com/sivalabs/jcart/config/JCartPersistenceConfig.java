package com.sivalabs.jcart.config;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan("com.sivalabs.jcart")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class JCartPersistenceConfig
{
	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource()
	{
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setValidationQueryTimeout(5);
		ds.setValidationQuery(env.getProperty("validationQuery"));

		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("com.sivalabs.jcart.entities");

		// let Hibernate know which database we're using.
		// note that this is vendor specific, not JPA
		Map<String, Object> opts = emf.getJpaPropertyMap();
		opts.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		opts.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		opts.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		opts.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));

		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(va);

		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager()
	{
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	
}
