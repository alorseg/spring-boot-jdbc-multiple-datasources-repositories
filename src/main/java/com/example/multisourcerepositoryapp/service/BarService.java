package com.example.multisourcerepositoryapp.service;

import com.example.multisourcerepositoryapp.entity.BarEntity;
import com.example.multisourcerepositoryapp.repository.BarRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {
    private final BarRepo barRepository;

    public BarService(BarRepo barRepositoryFactory) {
        barRepository = barRepositoryFactory;
    }

    public List<BarEntity> findAllBarEntities() {
        return (List<BarEntity>) barRepository.findAll();
    }
}
