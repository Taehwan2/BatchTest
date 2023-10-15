package com.batch.prac.book.batch;

import com.batch.prac.book.db.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SimpleJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final BookRepository bookRepository;

    @Bean
    public Job changeBook() {
        return jobBuilderFactory.get("boardJob")
                .start(changBookName())
                .on("FAILED")
                .stopAndRestart(changBookName())
                .on("*")
                .end()
                .end()
                .build();
    }

    @Bean
    public Step changBookName() {
        return stepBuilderFactory.get("changBookName")
                .tasklet(new BookTasklet(bookRepository))
                .build();
    }
}