package com.spring.professional.dao;

import com.spring.professional.ds.Person;

public class PersonDaoImpl implements PersonDao{
    @Override
    public Person findById(int id) {
        System.out.println("Searching for person ...");
        return new Person();
    }

    @Override
    public void save(Person person) {
        System.out.println("Saving person...");
    }
}
