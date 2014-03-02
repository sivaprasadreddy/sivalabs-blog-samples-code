package com.sivalabs.springdatarest.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.sivalabs.springdatarest" }, excludeFilters = {
		//@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION),
		//@ComponentScan.Filter(value = EnableWebMvc.class, type = FilterType.ANNOTATION)
 @ComponentScan.Filter(pattern = { "com.sivalabs.springdatarest.web.*", "com.sivalabs.springdatarest.rest.*" }, type = FilterType.REGEX)

})
@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
@EnableAsync
@EnableJpaRepositories(basePackages = { "com.sivalabs.springdatarest.repositories" })
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig
{

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public PlatformTransactionManager transactionManager()
	{
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);

		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.sivalabs.springdatarest.entities");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		factory.setJpaProperties(jpaProperties);

		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator()
	{
		return new HibernateExceptionTranslator();
	}

	@Bean
	public DataSource dataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public CacheManager cacheManager()
	{
		return new ConcurrentMapCacheManager();
	}

	@Bean
	public JavaMailSenderImpl javaMailSenderImpl()
	{
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(env.getProperty("smtp.host"));
		mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
		mailSenderImpl.setProtocol(env.getProperty("smtp.protocol"));
		mailSenderImpl.setUsername(env.getProperty("smtp.username"));
		mailSenderImpl.setPassword(env.getProperty("smtp.password"));

		Properties javaMailProps = new Properties();
		javaMailProps.put("mail.smtp.auth", true);
		javaMailProps.put("mail.smtp.starttls.enable", true);

		mailSenderImpl.setJavaMailProperties(javaMailProps);

		return mailSenderImpl;
	}
}
