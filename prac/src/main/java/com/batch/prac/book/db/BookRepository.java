package com.batch.prac.book.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {
    @Query("select s from Book s where s.during is true")
    List<Book> findBooksByDuringIsTrue();

}
