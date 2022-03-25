package com.dbs.tcdemo.controller;

import com.dbs.tcdemo.model.PersonDto;
import com.dbs.tcdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getPersons() {
        return personService.getAllPersons().stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }
}
