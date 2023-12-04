package com.example.event.message.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message,Long> {
}
