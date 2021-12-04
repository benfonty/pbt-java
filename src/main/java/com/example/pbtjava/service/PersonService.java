package com.example.pbtjava.service;

import com.example.pbtjava.model.Person;

public class PersonService {
    public boolean isOlderThan(Person person1, Person person2) {
        return person1.getAge() > person2.getAge();
    }

    public boolean haveSameName(Person person1, Person person2) {
        return person1.getName().equals(person2.getName());
    }
}
