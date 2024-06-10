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
public class FooIntegrationTest {

    @Autowired
    @Qualifier("fooDataSource")
    private DataSource fooDataSource;

    @Test
    void fooDataSource_instance() {
        assertThat(fooDataSource).isInstanceOf(HikariDataSource.class);
    }

    @Test
    @SneakyThrows
    void fooDataSource_name() {
        assertThat(fooDataSource.getConnection().getMetaData().getURL()).contains("foo");
    }

    @Test
    @SneakyThrows
    void fooDataSource_port() {
        assertThat(fooDataSource.getConnection().getMetaData().getURL()).contains("5432");
    }


}
