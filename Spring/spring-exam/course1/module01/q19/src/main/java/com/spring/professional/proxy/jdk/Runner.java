package com.spring.professional.proxy.jdk;

import com.spring.professional.dao.PersonDao;
import com.spring.professional.dao.PersonDaoImpl;
import com.spring.professional.ds.Person;

import java.lang.reflect.Proxy;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao =
                (PersonDao) Proxy.newProxyInstance(
                        PersonDao.class.getClassLoader(),
                        PersonDaoImpl.class.getInterfaces(),
                        new PersonDaoInvocationHandler(new PersonDaoImpl())
                );

        Person person = personDao.findById(3);
        personDao.save(person);
    }
}
