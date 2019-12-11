package com.springboot.springboot.Application.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

@Component("pFunction")
public class PersonFunctionality {
    private List<Person> people = new ArrayList<>();
    private AtomicLong id = new AtomicLong();
    Timer timer = new Timer();

    public PersonFunctionality() {
//      Creating a base
        people.add(new Person(id.incrementAndGet(),"Bob", "Newbie", false));
        people.add(new Person(id.incrementAndGet(), "Martin", "Newbie2", false));
    }

    public Person createPerson(Person person) {
        Long storeId = id.incrementAndGet();
        person.setId(storeId);
        people.add(person);

//      Check if it has been set to be deleted.
        if (person.isToDelete()) {
            timerToDelete(storeId);
        }
        return person;
    }

    public void timerToDelete(Long id) {
        timer.schedule(new TimerTask() {
            public void run() {
                deletePersonById(String.valueOf(id));
            }
        } , 10*1000);
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
//  Deletes a user based on the id entered in the url
    public void deletePersonById(String id) {
        Person personDel = people.stream().filter(p -> p.getIdString().equals(id)).findFirst().get();
        people.remove(personDel);
    }

}
