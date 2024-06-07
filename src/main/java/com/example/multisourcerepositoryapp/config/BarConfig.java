package com.example.multisourcerepositoryapp.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.convert.*;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class BarConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.bar")
    public DataSourceProperties barDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource barDataSource() {
        return barDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource barHikariDataSource() {
        return barDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public NamedParameterJdbcTemplate barNamedParameterJdbcTemplate(@Qualifier("barDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataAccessStrategy barDataAccessStrategy(@Qualifier("barNamedParameterJdbcTemplate") NamedParameterJdbcOperations operations,
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
}
