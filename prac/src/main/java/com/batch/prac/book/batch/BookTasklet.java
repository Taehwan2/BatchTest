package com.batch.prac.book.batch;

import com.batch.prac.book.db.Book;
import com.batch.prac.book.db.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class BookTasklet implements Tasklet {

    private final BookRepository bookRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("=====Start Change Board Status======");
        List<Book> bookList =bookRepository.findBooksByDuringIsTrue();

        if(bookList == null || bookList.isEmpty()) {
            log.info("=====변경할 게시글이 없습니다.=====");
        } else {
            for(Book book : bookList) {
               book.setAmountMoney(book.getMonthMoney()+book.getAmountMoney());
                bookRepository.save(book);
            }
        }
        log.info("=====End Change Board Status======");
        return RepeatStatus.FINISHED;
    }
}
