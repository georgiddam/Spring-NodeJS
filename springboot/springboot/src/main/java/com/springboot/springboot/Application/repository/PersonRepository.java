package com.springboot.springboot.Application.repository;

import com.springboot.springboot.Application.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

}