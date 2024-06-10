package com.example.multisourcerepositoryapp;

import com.example.multisourcerepositoryapp.foo.entity.FooEntity;
import com.example.multisourcerepositoryapp.foo.repo.FooRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class repo {

    @Autowired
    private FooRepo fooRepo;

    @Test
    void test() {
        final FooEntity newFooEntity = new FooEntity(UUID.fromString("3bdd33e6-7a5d-414a-9f31-911e0d126295"), "javi", "12456", "javi@email.com");

        fooRepo.save(newFooEntity);
    }

}
