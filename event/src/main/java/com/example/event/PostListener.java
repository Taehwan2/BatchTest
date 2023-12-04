package com.example.event;

import com.example.event.message.entity.Message;
import com.example.event.message.entity.MessageRepository;
import com.example.event.post.PostPublishedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PostListener  {

    private final MessageRepository messageRepository;

    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("------------------------");
        System.out.println(event.getPost().getName()+"is publish");
        messageRepository.save(
                Message.builder().content(event.getPost().getContent()).build()
        );
        System.out.println("------------------------");

    }
}
