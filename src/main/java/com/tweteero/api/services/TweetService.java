package com.tweteero.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteero.api.dto.TweetDTO;
import com.tweteero.api.model.Person;
import com.tweteero.api.model.Tweet;
import com.tweteero.api.repository.PersonRepository;
import com.tweteero.api.repository.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private PersonRepository personRepository;

    public void save(String username, TweetDTO tweet) {

        Optional<Person> person = personRepository.findByUsername(username);
        System.out.println(person);
        if (person.isPresent()) {
            repository.save(new Tweet(tweet, person.get().getUsername(), person.get().getAvatar()));
        }

    }

    public Page<Tweet> listAll(Pageable pageable) {
        System.out.println(pageable);
        return repository.findAll(pageable);

    }

    public List<Tweet> findByUsername(String username) {
        List<Tweet> list = repository.findAll();
        List<Tweet> listWithUsername = new ArrayList<>();

        for (Tweet tweet : list) {
            if (tweet.getUsername().equals(username)) {
                listWithUsername.add(tweet);
            }
        }

        return listWithUsername;
    }

}
