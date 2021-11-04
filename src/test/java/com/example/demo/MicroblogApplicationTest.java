package com.example.demo;

import com.example.demo.controller.PostController;

import com.example.demo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles()

class MicroblogApplicationTest {

    @MockBean
    private PostRepository postRepository;

    @Autowired
    //try to put mock
    private PostController postController;

    @Test
    public void contextLoads() {
        assertThat(postController).isNotNull();
    }
}