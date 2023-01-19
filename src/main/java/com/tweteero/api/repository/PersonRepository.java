package com.tweteero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tweteero.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
