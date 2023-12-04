package com.example.event.post.entity;

import com.example.event.post.PostPublishedEvent;
import com.example.event.post.dto.PostResponseDto;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Post extends AbstractAggregateRoot<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

   public Post publish(){
       this.registerEvent(new PostPublishedEvent((this)));
       return this;
   }

    public static PostResponseDto entityToResponseDto(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .name(post.getName())
                .content(post.getContent())
                .build();
    }
}
