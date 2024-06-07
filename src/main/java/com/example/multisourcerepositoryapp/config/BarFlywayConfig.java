package com.example.multisourcerepositoryapp.config;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BarFlywayConfig {
    private final DataSource barDataSource;

    public BarFlywayConfig(@Qualifier("barDataSource") DataSource dataSource) {
        this.barDataSource = dataSource;
    }

    @PostConstruct
    public void runMigration() {
        Flyway.configure()
                .dataSource(barDataSource)
                .locations("db/migration/bar")
                .baselineOnMigrate(true)
                .load()
                .migrate();
    }
}

