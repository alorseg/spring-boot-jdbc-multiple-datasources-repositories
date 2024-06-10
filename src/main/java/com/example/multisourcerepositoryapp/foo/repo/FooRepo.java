package com.example.multisourcerepositoryapp.foo.repo;

import com.example.multisourcerepositoryapp.foo.entity.FooEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepo extends CrudRepository<FooEntity, Integer> {
}
