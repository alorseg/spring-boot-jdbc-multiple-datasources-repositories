package com.example.multisourcerepositoryapp.foo.service;

import com.example.multisourcerepositoryapp.foo.entity.FooEntity;
import com.example.multisourcerepositoryapp.foo.repo.FooRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FooService {
    private final FooRepo fooRepository;

    public FooService(@Qualifier("fooRepository") FooRepo fooRepo) {
        this.fooRepository = fooRepo;
    }

    public List<FooEntity> findAllFooEntities() {
        return (List<FooEntity>) fooRepository.findAll();
    }
}
