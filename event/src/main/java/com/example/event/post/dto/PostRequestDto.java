package com.example.event.post.dto;

import com.example.event.post.entity.Post;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {

    private String name;

    private String content;

    public static Post RequestDtoToEntity(PostRequestDto postRequestDto){
        return Post.builder()
                    .name(postRequestDto.getName())
                    .content(postRequestDto.getContent())
                    .build();

    }
}
