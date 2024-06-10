package com.example.multisourcerepositoryapp.service;

import com.example.multisourcerepositoryapp.foo.entity.FooEntity;
import com.example.multisourcerepositoryapp.foo.service.FooService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FooServiceIntegrationTest {
    @Autowired
    private FooService fooService;

    @Test
    public void testFindAllFooEntities() {
        // Arrange
        // Act
        final List<FooEntity> entities = fooService.findAllFooEntities();

        // Assert
        assertThat(entities).isNotNull();
        assertThat(entities.size()).isEqualTo(5);
    }
}
