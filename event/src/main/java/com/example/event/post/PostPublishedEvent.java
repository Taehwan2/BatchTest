package com.example.event.post;

import com.example.event.post.entity.Post;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


public class PostPublishedEvent extends ApplicationEvent {

    private final Post post;
    public PostPublishedEvent(Object source) {
        super(source);
        this.post=(Post) source;
    }

    public Post getPost() {
        return post;
    }
}
