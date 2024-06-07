package com.example.multisourcerepositoryapp.datasourceconfiguration;


import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FooIntegrationTest {

    @Autowired
    @Qualifier("fooDataSource")
    private DataSource fooDataSource;

    @Autowired
    @Qualifier("fooNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate sut;

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

    @Test
    void sut_query() {
        // Arrange
        final String query = "SELECT email FROM users WHERE username=:username";

        final MapSqlParameterSource queryParam = new MapSqlParameterSource("username", "john_doe");

        // Act
        final String actual = sut.queryForObject(query, queryParam, String.class);

        // Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isEqualTo("john_doe@example.com");
    }
}
