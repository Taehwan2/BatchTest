package com.example.event.post.controller;

import com.example.event.post.dto.PostRequestDto;
import com.example.event.post.entity.Post;
import com.example.event.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    @PostMapping()
    public ResponseEntity enrollPost(@RequestBody PostRequestDto postRequestDto) {
        Post post = postService.enrollPost(PostRequestDto.RequestDtoToEntity(postRequestDto));
        return new ResponseEntity(Post.entityToResponseDto(post), HttpStatus.CREATED);
    }
}
