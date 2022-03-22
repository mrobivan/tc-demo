package com.dbs.tcdemo.controller;

import com.dbs.tcdemo.model.PersonDto;
import com.dbs.tcdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getPersons() {
        var persons = personService.getAllPersons();
        List<PersonDto> personsDtoList = new ArrayList<>();
        for(var person: persons) {
            var personDto = new PersonDto(person);
            personsDtoList.add(personDto);
        }
        return personsDtoList;
    }
}
