package com.example.chat1.dao;

import com.example.chat1.metier.Message;

import java.util.List;

public interface MessageDao {
    Message getMessageById(Long id);
    List<Message> getAllMessages();
    void addMessage(Message message);
    void updateMessage(Message message);
    void deleteMessage(Long id);
}
