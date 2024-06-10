package com.example.multisourcerepositoryapp.bar.service;

import com.example.multisourcerepositoryapp.bar.entity.BarEntity;
import com.example.multisourcerepositoryapp.bar.repo.BarRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {
    private final BarRepo barRepository;

    public BarService(@Qualifier("barRepository") BarRepo barRepo) {
        this.barRepository = barRepo;
    }

    public List<BarEntity> findAllBarEntities() {
        return (List<BarEntity>) barRepository.findAll();
    }
}
