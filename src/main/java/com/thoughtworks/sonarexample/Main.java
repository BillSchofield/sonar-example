package com.thoughtworks.sonarexample;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Person> personSet = new HashSet<Person>();

        personSet.add(new Person(0, "Bill", "Schofield"));
        personSet.add(new Person(0, "Bill", "Schofield"));
        personSet.add(new Person(1, "Carol", "Schofield"));

        for (Person person : personSet) {
            System.out.println(person.getFirstName() + person.getLastName());
        }
    }
}
