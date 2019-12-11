package com.springboot.springboot.Application.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
public class Person {
    @Id
    private long id;

    private String name;
    private String message;
    private boolean toDelete;

    public Person() {}

    public Person(long id, String name, String message, boolean ToDelete) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.toDelete = toDelete;
    }

    public long getId() {
        return id;
    }

    public boolean isToDelete() {
        return toDelete;
    }

    public String getIdString() {
        return Long.toString(id);
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%s, name='%s', message='%s']",
                id, name, message);
    }
}
