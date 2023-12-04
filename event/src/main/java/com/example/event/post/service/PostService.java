package com.example.event.post.service;

import com.example.event.post.PostPublishedEvent;
import com.example.event.post.entity.Post;
import com.example.event.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public Post enrollPost(Post post){
        log.info("PostServie: enrollPost exec");
        applicationEventPublisher.publishEvent(post.publish());
        return repository.save(post);
    }
}
