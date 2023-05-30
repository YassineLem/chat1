<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.chat1.metier.Message" %>
<%@ page import="com.example.chat1.metier.User" %>
<%@ page import="com.example.chat1.dao.UserDaoImpl" %>
<%@ page import="com.example.chat1.dao.MessageDaoImpl" %>

<%
    MessageDaoImpl messageDAO = new MessageDaoImpl();
    List<Message> messages = messageDAO.getAllMessages();
    UserDaoImpl userDAO = new UserDaoImpl();
    for (Message message : messages) {
        User user = (User) message.getUser();
        String username = (user != null && user.getName() != null) ? user.getName() : "Unknown User";
%>
<div class="message">
    <span class="user"><%= username %>:</span>
    <span class="content"><%= message.getMessage() %></span>
</div>
<%
    }
%>
