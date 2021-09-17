package com.github.knextsunj.musicincstore.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.github.knextsunj.musicincstore.constants.CommonConstants;
import com.github.knextsunj.musicincstore.constants.DataSourceConstants;
import com.github.knextsunj.musicincstore.constants.JpaConstants;

@Configuration
@PropertySource(CommonConstants.PROPS_FILE_PATH)
public class JpaConfig implements EnvironmentAware {

	private static final Logger logger = LogManager.getLogger(JpaConfig.class);

	private Environment environment;

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_DIALECT_KEY),
				environment.getProperty(JpaConstants.HIBERNATE_DIALECT_VALUE));
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_FORMAT_SQL), true);
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_USE_SQLCOMMENTS), true);
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_SHOW_SQL), true);
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_MAX_FETCH_DEPTH), 3);
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_JDBC_BATCH_SIZE), 10);
		hibernateProp.put(environment.getProperty(JpaConstants.HIBERNATE_JDBC_FETCH_SIZE), 50);
		return hibernateProp;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan(environment.getProperty(JpaConstants.ENTITIES_PACKAGE));
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	@Bean
	public DataSource dataSource() {

		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName(environment.getProperty(DataSourceConstants.JNDI_URL_KEY));
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(DataSource.class);
		try {
			jndiObjectFactoryBean.afterPropertiesSet();
		} catch (IllegalArgumentException illegalArgEx) {
			illegalArgEx.printStackTrace();
		} catch (NamingException namingEx) {
			namingEx.printStackTrace();
		}
		return (DataSource) jndiObjectFactoryBean.getObject();
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;

	}

}
