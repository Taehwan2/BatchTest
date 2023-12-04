package com.batch.prac.book.controller;

import com.batch.prac.book.db.Book;
import com.batch.prac.book.dto.BookRequestDto;
import com.batch.prac.book.dto.BookResponseDto;
import com.batch.prac.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {
    private final BookService bookService;
    @PostMapping("")
    public BookResponseDto post(@RequestBody BookRequestDto bookRequestDto){
        Book book = bookService.save(bookRequestDto.requestToentity(bookRequestDto));
        return book.entityToRespone(book);
    }

    @GetMapping("/{id}")
    public BookResponseDto getOne(@PathVariable(name = "id") Long id){
        Book book = bookService.getOne(id);
        return book.entityToRespone(book);
    }
    @GetMapping("/")
    public List<BookResponseDto> getall(){
        List<BookResponseDto> books = bookService.getAll();
        return books;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        bookService.delete(id);
    }

}
