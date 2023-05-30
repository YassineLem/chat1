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
    String[] photoNames = {"1.png", "2.jpg", "3.jpg", "4.jpg", "5.jpg"};
    int randomIndex = (int) (Math.random() * photoNames.length);
    String randomPhoto = photoNames[randomIndex];
    String imagePath = "image/" + randomPhoto;
    for (Message message : messages) {
        User user = (User) message.getUser();
        String username = (user != null && user.getName() != null) ? user.getName() : "Unknown User";
%>
    <div class="inbox_msg">
        <div class="mesgs">
            <div class="msg_history">
                <div class="incoming_msg">
                    <div class="incoming_msg_img"> <img src="<%=imagePath%>" alt="sunil"> </div>
                    <span><%=username %></span>
                    <div class="received_msg">
                        <div class="received_withd_msg">
                            <p><%= message.getMessage() %></p>
                            <span class="time_date"> <%=message.getDate_creation()%></span></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%
    }
%>

