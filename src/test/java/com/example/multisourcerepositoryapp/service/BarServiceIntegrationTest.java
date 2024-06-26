package com.example.multisourcerepositoryapp.service;

import com.example.multisourcerepositoryapp.bar.entity.BarEntity;
import com.example.multisourcerepositoryapp.bar.service.BarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BarServiceIntegrationTest {
    @Autowired
    private BarService barService;

    @Test
    public void testFindAllBarEntities() {
        // Arrange
        // Act
        final List<BarEntity> ldapEntities = barService.findAllBarEntities();

        // Assert
        assertThat(ldapEntities).isNotNull();
        assertThat(ldapEntities.size()).isEqualTo(9);
    }
}

