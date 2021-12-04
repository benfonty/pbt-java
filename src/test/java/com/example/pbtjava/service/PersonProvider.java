package com.example.pbtjava.service;

import com.example.pbtjava.model.Person;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.providers.ArbitraryProvider;
import net.jqwik.api.providers.TypeUsage;

import java.util.Collections;
import java.util.Set;

public class PersonProvider implements ArbitraryProvider {
    @Override
    public boolean canProvideFor(TypeUsage targetType) {
        return targetType.isOfType(Person.class);
    }

    @Override
    public Set<Arbitrary<?>> provideFor(TypeUsage targetType, SubtypeProvider subtypeProvider) {
        Arbitrary<Integer> age = Arbitraries.integers()
                .between(0, 100);
        Arbitrary<String> name = Arbitraries.of("Titi", "Tata", "Toto");
        Arbitrary<String> familyName = Arbitraries.strings();
        return Collections.singleton(Combinators.combine(name, familyName, age).as(Person::new));
    }
}
