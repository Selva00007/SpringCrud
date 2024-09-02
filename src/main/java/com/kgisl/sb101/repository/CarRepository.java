package com.kgisl.sb101.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb101.entity.Carcollections;

@Repository
public interface CarRepository extends ListCrudRepository<Carcollections,Integer>{

    
}
