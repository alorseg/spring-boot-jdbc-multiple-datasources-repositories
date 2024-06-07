package com.example.multisourcerepositoryapp.config;

import com.example.multisourcerepositoryapp.repository.FooRepo;
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
public class FooRepoConfig {
    private final JdbcRepositoryFactory fooRepositoryFactory;

    public FooRepoConfig(
            @Qualifier("fooDataAccessStrategy") DataAccessStrategy dataAccessStrategy,
            RelationalMappingContext context,
            JdbcConverter converter,
            Dialect dialect,
            ApplicationEventPublisher publisher,
            @Qualifier("fooNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

        this.fooRepositoryFactory =
                new JdbcRepositoryFactory(
                        dataAccessStrategy,
                        context,
                        converter,
                        dialect,
                        publisher,
                        namedParameterJdbcTemplate);
    }

    @Bean
    @Primary
    public FooRepo fooRepositoryTest() {
        return fooRepositoryFactory.getRepository(FooRepo.class);
    }
}
