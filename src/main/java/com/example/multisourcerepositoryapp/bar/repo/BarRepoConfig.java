package com.example.multisourcerepositoryapp.bar.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;

@Configuration
public class BarRepoConfig {

    private final JdbcRepositoryFactory jdbcRepositoryFactory;

    public BarRepoConfig(@Qualifier("barJdbcRepositoryFactory") JdbcRepositoryFactory jdbcRepositoryFactory) {
        this.jdbcRepositoryFactory = jdbcRepositoryFactory;
    }

    @Bean
    public BarRepo barRepository() {
        return jdbcRepositoryFactory.getRepository(BarRepo.class);
    }
}
