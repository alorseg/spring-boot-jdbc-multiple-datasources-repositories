package com.example.multisourcerepositoryapp.namedParameterJdbcTemplate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
public class barNamedParameterJdbcTemplateIntegrationTest {

    @Autowired
    @Qualifier("barNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate sut;

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
