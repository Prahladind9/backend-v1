package com.spring.professional.proxy.manual;

import com.spring.professional.dao.PersonDao;
import com.spring.professional.dao.PersonDaoImpl;
import com.spring.professional.ds.Person;

public class Runner {
    public static void main(String[] args) {
//        PersonDao personDao = new PersonDaoImpl();
        PersonDao personDao = new PersonDaoProxy(
                new PersonDaoImpl()
        );


        Person person = personDao.findById(3);
        personDao.save(person);
    }
}
