package com.example.multisourcerepositoryapp.repository;

import com.example.multisourcerepositoryapp.entity.FooEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepo extends CrudRepository<FooEntity, Integer> {
}
