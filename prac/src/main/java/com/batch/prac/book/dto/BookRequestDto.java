package com.batch.prac.book.dto;

import com.batch.prac.book.db.Book;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestDto {
    private String name;


    private int amountMoney;

    private int monthMoney;

    private boolean during;
    public static Book requestToentity(BookRequestDto requestDto){
        return Book.builder().amountMoney(requestDto.getAmountMoney()).monthMoney(requestDto.getMonthMoney()).
                name(requestDto.getName()).during(requestDto.isDuring()).build();
    }
}
