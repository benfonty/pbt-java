package com.example.pbtjava.service;

import com.example.pbtjava.model.Person;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.UseType;
import org.junit.jupiter.api.BeforeAll;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PersonServiceTest {

    private PersonService personService;

    public PersonServiceTest() {
        this.personService = new PersonService();
    }

    @Property
    public void testPersonNames(@ForAll Person person1, @ForAll Person person2) {
        if (personService.haveSameName(person1, person2)) {
            assertThat(personService.haveSameName(person2, person1)).isTrue();
        } else {
            assertThat(personService.haveSameName(person2, person1)).isFalse();
        }
    }

    @Property
    public void testPersonAges(@ForAll Person person1, @ForAll Person person2) {
        if (personService.isOlderThan(person1, person2)) {
            assertThat(personService.isOlderThan(person2, person1)).isFalse();
        }
    }
}
