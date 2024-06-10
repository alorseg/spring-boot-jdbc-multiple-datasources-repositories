package com.example.multisourcerepositoryapp.foo.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;

@Configuration
public class FooRepoConfig {

    private final JdbcRepositoryFactory jdbcRepositoryFactory;

    public FooRepoConfig(@Qualifier("fooJdbcRepositoryFactory") JdbcRepositoryFactory jdbcRepositoryFactory) {
        this.jdbcRepositoryFactory = jdbcRepositoryFactory;
    }

    @Bean
    public FooRepo fooRepository() {
        return jdbcRepositoryFactory.getRepository(FooRepo.class);
    }
}
