package com.example.chat1;

import com.example.chat1.dao.MessageDaoImpl;
import com.example.chat1.dao.UserDaoImpl;
import com.example.chat1.metier.Message;
import com.example.chat1.metier.User;

public class main {
    public static void main(String[] args) {
        // Instantiate the UserDao implementation

        UserDaoImpl userDao = new UserDaoImpl();
        MessageDaoImpl messageDao=new MessageDaoImpl();

        // Create a new User object
        User newUser = new User("John Doe", null); // Assuming you don't have any messages initially
        Message message=new Message("hello world");
        // Add the user
        userDao.addUser(newUser);
        messageDao.addMessage(message);
        // The user has been created and added to the database
        System.out.println("New user created with ID: " + newUser.getId_user());
    }
}
