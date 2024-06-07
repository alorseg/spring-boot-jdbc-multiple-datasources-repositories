package com.example.multisourcerepositoryapp.config;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FooFlywayConfig {
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
