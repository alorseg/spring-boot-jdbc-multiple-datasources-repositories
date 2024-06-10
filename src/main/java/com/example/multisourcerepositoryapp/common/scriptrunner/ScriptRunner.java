package com.example.multisourcerepositoryapp.common.scriptrunner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class ScriptRunner {

    @Bean
    @ConditionalOnProperty(name = "print-bean-list", havingValue = "true")
    public CommandLineRunner printBeans(ApplicationContext context) {
        return args -> {
            Map<String, Object> beans = context.getBeansWithAnnotation(Bean.class);
            beans.forEach((beanName, bean) -> System.out.println(beanName + ": " + bean.getClass().getName()));
        };
    }

    @Bean
    public CommandLineRunner fooSeedingDatabase(@Qualifier("fooDataSource") DataSource dataSource) {
        return args ->
                ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("db/seeding/foo/data.sql"));
    }

    @Bean
    public CommandLineRunner barSeedingDatabase(@Qualifier("barDataSource") DataSource dataSource) {
        return args ->
                ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("db/seeding/bar/data.sql"));
    }
}
