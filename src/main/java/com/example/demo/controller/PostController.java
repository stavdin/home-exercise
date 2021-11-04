package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/posts")
public class PostController {

    private final PostRepository repository;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return repository.save(post);
    }

    @PutMapping(value = "/update")
    public Post updatePost(@RequestBody Post post) {
        return repository.save(post);
    }

    @GetMapping(value = "/{id}")
    @Cacheable("post")
    public Optional<Post> findById(@PathVariable long id) {
        String s = "findById invoked with id = {}";
        //in order to make sure that the data comes from the cache
        System.out.println(s);
        log.info(s, id);
        return repository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePost(@PathVariable long id) {
        repository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public void addLike(@PathVariable long id) {
        Post post = repository.findById(id).get();
        post.setNumOfLikes(post.getNumOfLikes() + 1);
        repository.save(post);
    }

    @GetMapping(value = "/from/{timestamp}")
    public Post findByTopTrending(@PathVariable long timestamp) {
        List<Post> posts = repository.findAll();
        Post post = posts.get(0);
        for (Post p : posts) {
            if (p.getDate().getTime() > timestamp && p.getNumOfLikes() > post.getNumOfLikes()) {
                post = p;
            }
        }
        return post;
    }
}




