package com.example.pbtjava.service;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePbtTest {

    @Property
    public void additionIsCommutative(@ForAll long x, @ForAll long y) {
        assertThat(x + y).isEqualTo(y + x);
    }

    @Property
    public void additionIsAssociative(@ForAll long x, @ForAll long y, @ForAll long z) {
        assertThat((x + y) + z).isEqualTo(x + (y + z));
    }

    @Property
    public void additionHasNeutralElementZero(@ForAll long x) {
        assertThat(x + 0).isEqualTo(x);
    }
}
