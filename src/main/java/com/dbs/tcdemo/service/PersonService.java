package com.dbs.tcdemo.service;

import com.dbs.tcdemo.model.Person;
import com.dbs.tcdemo.model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void prepareDatabase() {
        personRepository.deleteAll();
        var person1 = new Person();
        person1.setName("Robert Fripp");
        personRepository.save(person1);
        var person2 = new Person();
        person2.setName("Bill Bruford");
        personRepository.save(person2);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
