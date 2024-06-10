package com.example.multisourcerepositoryapp.foo.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.core.convert.*;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactory;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class FooConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.foo")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource fooDataSource() {
        return fooDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource fooHikariDataSource() {
        return fooDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @Primary
    public NamedParameterJdbcTemplate fooNamedParameterJdbcTemplate(@Qualifier("fooDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    @Primary
    public DataAccessStrategy fooDataAccessStrategy(@Qualifier("fooNamedParameterJdbcTemplate") NamedParameterJdbcOperations operations,
                                                    JdbcConverter jdbcConverter,
                                                    JdbcMappingContext context,
                                                    Dialect dialect) {

        final SqlGeneratorSource sqlGeneratorSource =
                new SqlGeneratorSource(
                        context,
                        jdbcConverter,
                        dialect
                );

        final DataAccessStrategyFactory factory =
                new DataAccessStrategyFactory(
                        sqlGeneratorSource,
                        jdbcConverter,
                        operations,
                        new SqlParametersFactory(context, jdbcConverter),
                        new InsertStrategyFactory(operations, dialect)
                );

        return factory.create();
    }

    @Bean
    public JdbcRepositoryFactory fooJdbcRepositoryFactory(
            @Qualifier("fooDataAccessStrategy") DataAccessStrategy dataAccessStrategy,
            RelationalMappingContext context,
            JdbcConverter converter,
            Dialect dialect,
            ApplicationEventPublisher publisher,
            @Qualifier("fooNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

        return new JdbcRepositoryFactory(
                dataAccessStrategy,
                context,
                converter,
                dialect,
                publisher,
                namedParameterJdbcTemplate);
    }

    @Configuration
    public static class FooFlywayConfig {
        private final DataSource barDatasource;

        public FooFlywayConfig(@Qualifier("fooDataSource") DataSource dataSource) {
            this.barDatasource = dataSource;
        }

        @PostConstruct
        public void runMigration() {
            Flyway.configure()
                    .dataSource(barDatasource)
                    .locations("db/migration/foo")
                    .baselineOnMigrate(true)
                    .load()
                    .migrate();
        }
    }

}
