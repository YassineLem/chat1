package com.example.chat1.metier;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_message;
    private String session;
    @ManyToOne
    private User user;
    @NotNull
    private String Message;
    private LocalDate date_creation;

    public Message() {
        date_creation=LocalDate.now();
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message(String message) {
        Message = message;
        this.date_creation = LocalDate.now();
    }

    public Long getId_message() {
        return Id_message;
    }

    public void setId_message(Long id_message) {
        Id_message = id_message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }
}
