package com.batch.prac.book.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDto {
    private Long bookId;
    private String naem;

    private int amountMoney;

    private int monthMoney;
    private boolean during;
}
