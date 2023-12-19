package br.com.wrs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = {"br.com.wrs.dao"},
        entityManagerFactoryRef = "dwEntityManager",
        transactionManagerRef = "wrsTransactionManager")
public class RepositoryConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dwDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.driverClassName"))
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password."))
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dwEntityManager(@Qualifier("dwDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.database-platform"));

        return builder
                .dataSource(dataSource)
                .packages("br.com.dw.modelo")
                .properties(properties)
                .build();
    }

    @Bean
    public PlatformTransactionManager dwTransactionManager(@Qualifier("dwEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

