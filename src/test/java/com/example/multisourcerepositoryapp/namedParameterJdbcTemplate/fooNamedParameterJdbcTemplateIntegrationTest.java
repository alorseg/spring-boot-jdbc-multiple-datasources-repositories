package com.example.multisourcerepositoryapp.namedParameterJdbcTemplate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class fooNamedParameterJdbcTemplateIntegrationTest {

    @Autowired
    @Qualifier("fooNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate sut;

    @Test
    void sut_query() {
        // Arrange
        final String query = "SELECT email FROM users WHERE username=:username";

        final MapSqlParameterSource queryParam = new MapSqlParameterSource("username", "albertlo");

        // Act
        final String actual = sut.queryForObject(query, queryParam, String.class);

        // Assert
        Assertions.assertThat(actual).isNotNull();
        Assertions.assertThat(actual).isEqualTo("albert_lo@example.com");
    }
}
