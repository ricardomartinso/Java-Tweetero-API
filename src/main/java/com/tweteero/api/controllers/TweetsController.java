package com.tweteero.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteero.api.dto.TweetDTO;
import com.tweteero.api.model.Tweet;
import com.tweteero.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class TweetsController {

    @Autowired
    private TweetService service;

    @GetMapping("/tweets")
    public ResponseEntity<Page<Tweet>> list(@PageableDefault(size = 5, page = 0) Pageable pageable) {

        return ResponseEntity.ok(service.listAll(pageable));

    }

    @GetMapping("/tweets/{username}")
    public List<Tweet> listByUsername(@PathVariable String username) {

        return service.findByUsername(username);
    }

    @PostMapping("/tweets")
    public void createTweet(@RequestBody @Valid TweetDTO req) {
        service.save(req);
    }

}
