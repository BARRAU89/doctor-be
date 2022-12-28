package net.yorksolutions.doctorbe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    public Long id;
    public String name;

    public Foo() {
    }

    public Foo(String name) {
        this.name = name;
    }
}
