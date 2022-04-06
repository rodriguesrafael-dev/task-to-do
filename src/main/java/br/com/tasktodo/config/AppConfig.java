package br.com.tasktodo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.tasktodo.repository.PriorityRepository;
import br.com.tasktodo.repository.PriorityRepositoryImpl;
import br.com.tasktodo.repository.TaskRepository;
import br.com.tasktodo.repository.TaskRepositoryImpl;
import br.com.tasktodo.repository.TaskStattusRepository;
import br.com.tasktodo.repository.TaskStattusRepositoryImpl;
import br.com.tasktodo.repository.UserRepository;
import br.com.tasktodo.repository.UserRepositoryImpl;
import br.com.tasktodo.services.PriorityServices;
import br.com.tasktodo.services.PriorityServicesImpl;
import br.com.tasktodo.services.TaskServices;
import br.com.tasktodo.services.TaskServicesImpl;
import br.com.tasktodo.services.TaskStattusServices;
import br.com.tasktodo.services.TaskStattusServicesImpl;
import br.com.tasktodo.services.UserServices;
import br.com.tasktodo.services.UserServicesImpl;

@Configuration
@ComponentScan("br.com.tasktodo")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(managerDataSource());
		entityManager.setPackagesToScan(new String[] {"br.com.tasktodo.entity"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		entityManager.setJpaProperties(additionalProperties());
		
		return entityManager;
	}

	@Bean
	public DriverManagerDataSource managerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();	
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/taskdb?createDatabaseIfNotExist=true");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManager) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManager);
		
		return jpaTransactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTransation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	public Properties additionalProperties() {
		Properties properties = new Properties();	
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	@Bean
	public UserRepository userRepository() {
		return new UserRepositoryImpl();
	}
	
	@Bean
	public UserServices userServices() {
		return new UserServicesImpl(userRepository());
	}
	
	@Bean
	public TaskRepository taskRepository() {
		return new TaskRepositoryImpl();
	}
	
	@Bean
	public TaskServices taskServices() {
		return new TaskServicesImpl(taskRepository());
	}
	
	@Bean
	public PriorityRepository priorityRepository() {
		return new PriorityRepositoryImpl();
	}
	
	@Bean
	public PriorityServices priorityServices() {
		return new PriorityServicesImpl(priorityRepository());
	}
	
	@Bean
	public TaskStattusRepository taskStattusRepository() {
		return new TaskStattusRepositoryImpl();
	}
	
	@Bean
	public TaskStattusServices taskStattusServices() {
		return new TaskStattusServicesImpl(taskStattusRepository());
	}
	
}
