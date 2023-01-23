package com.tweteero.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteero.api.dto.PersonDTO;
import com.tweteero.api.model.Person;
import com.tweteero.api.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public void save(PersonDTO req) {
        repository.save(new Person(req));
    }

    public void update(Long id, PersonDTO req) {
        repository.findById(id).map(person -> {
            person.setUsername(req.username());
            person.setAvatar(req.avatar());
            return repository.save(person);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
