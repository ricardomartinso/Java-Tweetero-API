package com.tweteero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteero.api.dto.PersonDTO;
import com.tweteero.api.model.Person;
import com.tweteero.api.repository.PersonRepository;

@RestController
@RequestMapping
public class PersonControllers {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> listAll() {
        return repository.findAll();
    }

    @PostMapping("/sign-up")
    public void createUser(@RequestBody PersonDTO req) {
        repository.save(new Person(req));

    }
}
