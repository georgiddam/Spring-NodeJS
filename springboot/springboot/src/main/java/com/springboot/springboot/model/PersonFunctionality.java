package com.springboot.springboot.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component("pFunction")
public class PersonFunctionality {
    private List<Person> people = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    public PersonFunctionality() {
//      Creating a base
        people.add(new Person(id.incrementAndGet(),"Bob", "Newbie"));
        people.add(new Person(id.incrementAndGet(), "Martin", "Newbie2"));
    }

    public Person createPerson(Person person) {
        person.setId(id.incrementAndGet());
        people.add(person);
        return person;
    }

    public List<Person> getPeople() {
        return people;
    }

//  Get person by ID from the list
    public Person getPersonById(String id) {
//      Get the array through a stream, filter the ID's and compare them to the ID input from the URL and get the first value that matches.
        return people.stream().filter(p -> p.getIdString().equals(id)).findFirst().get();
    }

    public void changePersonById(Person person, String id) {
        for (Person p : people) {
            if(p.getIdString().equals(id)) {
                person.setId(p.getId());
                people.set(people.indexOf(p), person);

            }
        }
    }
}
