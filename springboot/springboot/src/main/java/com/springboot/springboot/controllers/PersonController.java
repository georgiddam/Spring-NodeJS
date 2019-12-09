package com.springboot.springboot.controllers;

import com.springboot.springboot.model.Person;
import com.springboot.springboot.model.PersonFunctionality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonFunctionality pFunction;

    @GetMapping("/hello")
    public String helloMessage(){
        return "Hello Spring World";
    }

//  Testing this using postman app
    @PostMapping("/people")
    public void addNewPerson(@RequestBody Person person ) {
        pFunction.createPerson(person);
    }

    @GetMapping("/people")
    public List<Person> getAllPeople() {
        return pFunction.getPeople();
    }

//  The {} brackets tell Spring that its a variable. The name of the variable needs to be the same as I pass in the function
    @GetMapping("/person/{id}")
    public void getSpecificPerson(@PathVariable String id) {
        pFunction.getPersonById(id);
    }

//  Changing the data based on the id variable
    @PutMapping("person/{id}")
    public void changePerson(@RequestBody Person person, @PathVariable String id) {
        pFunction.changePersonById(person, id);
    }
}
