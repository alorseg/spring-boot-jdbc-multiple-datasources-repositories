package com.example.multisourcerepositoryapp.bar.repo;

import com.example.multisourcerepositoryapp.bar.entity.BarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepo extends CrudRepository<BarEntity, Integer> {
}
