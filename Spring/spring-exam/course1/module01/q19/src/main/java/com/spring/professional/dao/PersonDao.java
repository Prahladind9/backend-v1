package com.spring.professional.dao;

import com.spring.professional.ds.Person;

public interface PersonDao {
    Person findById(int id);
    void save(Person person);
}
