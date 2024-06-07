package com.example.multisourcerepositoryapp.service;

import com.example.multisourcerepositoryapp.entity.FooEntity;
import com.example.multisourcerepositoryapp.repository.FooRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FooService {
    private final FooRepo fooRepository;

    public FooService(FooRepo fooRepositoryFactory) {
        fooRepository = fooRepositoryFactory;
    }

    public List<FooEntity> findAllFooEntities() {
        return (List<FooEntity>) fooRepository.findAll();
    }
}
