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
class BarIntegrationTest {

    @Autowired
    @Qualifier("barDataSource")
    private DataSource barDataSource;

    @Autowired
    @Qualifier("barNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate sut;

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

    @Test
    void sut_query() {
        // Arrange
        final String query = "SELECT COUNT(*) FROM user_grades";
        final int expectedResult = 9;

        // Act
        final String actual = sut.queryForObject(query, new MapSqlParameterSource(), String.class);

        // Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(expectedResult).isEqualTo(9);
    }
}