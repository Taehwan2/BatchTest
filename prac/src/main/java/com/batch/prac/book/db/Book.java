package com.batch.prac.book.db;

import com.batch.prac.book.dto.BookResponseDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    private int amountMoney;

    private int monthMoney;
    private boolean during;
    public static BookResponseDto entityToRespone(Book book){
        return BookResponseDto.builder()
                .bookId(book.getBookId())
                .monthMoney(book.getMonthMoney())
                .amountMoney(book.getAmountMoney())
                .naem(book.getName())
                .during(book.isDuring())
                .build();
    }
}
