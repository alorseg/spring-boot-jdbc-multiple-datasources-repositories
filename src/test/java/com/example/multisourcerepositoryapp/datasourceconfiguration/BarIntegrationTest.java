package com.example.multisourcerepositoryapp.datasourceconfiguration;

import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BarIntegrationTest {

    @Autowired
    @Qualifier("barDataSource")
    private DataSource barDataSource;

    @Test
    void barDataSource_instance() {
        assertThat(barDataSource).isInstanceOf(HikariDataSource.class);
    }

    @Test
    @SneakyThrows
    void barDataSource_name() {
        assertThat(barDataSource.getConnection().getMetaData().getURL()).contains("bar");
    }

    @Test
    @SneakyThrows
    void barDataSource_port() {
        assertThat(barDataSource.getConnection().getMetaData().getURL()).contains("5433");
    }


}