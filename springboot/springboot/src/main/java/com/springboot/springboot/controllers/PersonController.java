package com.springboot.springboot.controllers;

import com.springboot.springboot.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private List<Person> people = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    public PersonController() {
        people.add(new Person(id.incrementAndGet(),"Bob", "Newbie"));
        people.add(new Person(id.incrementAndGet(), "Martin", "Newbie2"));
    }

    @GetMapping("/hello")
    public String helloMessage(){
        return "Hello Spring World";
    }

//  Testing this using postman app
    @PostMapping("/people")
    public Person createPerson(@RequestBody Person person ) {
        person.setId(id.incrementAndGet());
        people.add(person);
        return person;
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        return people;
    }

//  The {} brackets tell Spring that its a variable. The name of the variable needs to be the same as I pass in the function
    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable String id) {
//      Get the array through a stream, filter the ID's and compare them to the ID input from the URL and get the first value that matches.
        return people.stream().filter(p -> p.getIdString().equals(id)).findFirst().get();
    }

//  Changing the data based on the id variable
    @PutMapping("person/{id}")
    public void changePerson(@RequestBody Person person, @PathVariable String id) {
        for (Person p : people) {
            if(p.getIdString().equals(id)) {
                person.setId(p.getId());
                people.set(people.indexOf(p), person);

            }
        }
    }
}
