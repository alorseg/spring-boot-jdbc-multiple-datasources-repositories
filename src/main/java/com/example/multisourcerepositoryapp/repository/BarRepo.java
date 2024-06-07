package com.example.multisourcerepositoryapp.repository;

import com.example.multisourcerepositoryapp.entity.BarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepo extends CrudRepository<BarEntity, Integer> {
}
