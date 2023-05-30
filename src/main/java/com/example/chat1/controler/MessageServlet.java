package com.example.chat1.controler;

import com.example.chat1.dao.MessageDaoImpl;
import com.example.chat1.dao.UserDaoImpl;
import com.example.chat1.metier.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet(name = "MessageServlet", value = "/MessageServlet")
public class MessageServlet extends HttpServlet {
    private UserDaoImpl userDAO;
    public void init() {
        userDAO = new UserDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message myMessage = new Message();
        MessageDaoImpl messageDAO = new MessageDaoImpl();
        HttpSession session = request.getSession();
        String sessionID = session.getId();
        String content = request.getParameter("message");
        int parameterValue;
        String value = request.getParameter("senderID2");
        try {
            parameterValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            parameterValue = 1;
            e.printStackTrace();
        }

        myMessage.setMessage(content);
        myMessage.setUser(userDAO.getUserById(Long.parseLong(String.valueOf(parameterValue))));
        myMessage.setSession(sessionID);
        messageDAO.addMessage(myMessage);
        request.setAttribute("userID", request.getAttribute("userID"));

        this.getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);

    }
}
