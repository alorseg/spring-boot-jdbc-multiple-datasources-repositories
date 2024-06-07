package com.example.multisourcerepositoryapp.config;

import com.example.multisourcerepositoryapp.repository.BarRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.core.convert.DataAccessStrategy;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class BarRepoConfig {
    private final JdbcRepositoryFactory barRepositoryFactory;

    public BarRepoConfig(
            @Qualifier("barDataAccessStrategy") DataAccessStrategy dataAccessStrategy,
            RelationalMappingContext context,
            JdbcConverter converter,
            Dialect dialect,
            ApplicationEventPublisher publisher,
            @Qualifier("barNamedParameterJdbcTemplate") NamedParameterJdbcTemplate ldapNamedParameterJdbcTemplate) {

        this.barRepositoryFactory = new JdbcRepositoryFactory(
                dataAccessStrategy,
                context,
                converter,
                dialect,
                publisher,
                ldapNamedParameterJdbcTemplate);
    }

    @Bean
    @Primary
    public BarRepo barRepositoryTest() {
        return barRepositoryFactory.getRepository(BarRepo.class);
    }

}