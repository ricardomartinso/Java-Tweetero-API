package com.tweteero.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteero.api.dto.PersonDTO;
import com.tweteero.api.model.Person;
import com.tweteero.api.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class PersonControllers {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> listAll() {
        return service.findAll();
    }

    @PostMapping("/sign-up")
    public void create(@RequestBody @Valid PersonDTO req) {

        service.save(req);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid PersonDTO req) {
        service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
