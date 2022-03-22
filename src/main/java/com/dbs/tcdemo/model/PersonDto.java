package com.dbs.tcdemo.model;

public class PersonDto {
    private String name;

    public PersonDto(Person person) {
        this.name = person.getName();
    }

    public String getName() {
        return name;
    }

}
