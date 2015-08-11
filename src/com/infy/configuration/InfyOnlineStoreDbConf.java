/**
 * 
 */
package com.infy.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author AvinashVaidya
 *
 */
@Configuration
@EnableTransactionManagement
@ImportResource("classpath:/com/infy/properties/Spring-InfyOnlineStore-Database.xml")
public class InfyOnlineStoreDbConf {

	@Autowired
	private DataSource dataSource;

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(entityManagerFactoryBean().getObject());
		return transactionManager;

	}

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean entityManagerFactoryBean() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		factoryBean.setDataSource(dataSource);

		factoryBean.setPackagesToScan(new String[] { "com.infy.vo" });

		// hibernate properties
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.jdbc.batch_size", "100");
		hibernateProperties.setProperty("order_inserts", "true");
		hibernateProperties.setProperty("hibernate.show_sql", "true");

		factoryBean.setHibernateProperties(hibernateProperties);

		return factoryBean;
	}

	/**
	 * Create jdbc template as this can be used to execute small queries
	 * 
	 * @return JdbcTemplate
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

}
