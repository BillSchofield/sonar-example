package com.thoughtworks.sonarexample;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(0, "Bill", "Schofield");
        Set<Person> personSet = new HashSet<Person>();

        personSet.add(person);
    }
}
