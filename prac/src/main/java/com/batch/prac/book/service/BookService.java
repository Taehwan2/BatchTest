package com.batch.prac.book.service;

import com.batch.prac.book.db.Book;
import com.batch.prac.book.db.BookRepository;
import com.batch.prac.book.dto.BookResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository repository;

    public Book save(Book book){
        return  repository.save(book);
    }

    public Book getOne(Long id){
        return repository.findById(id).orElseThrow(()->new NoSuchElementException());
    }

    public List<BookResponseDto> getAll(){
        return repository.findAll().stream().map((a)->Book.entityToRespone(a)).collect(Collectors.toList());
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
