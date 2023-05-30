package com.example.chat1.controler;

import com.example.chat1.dao.UserDaoImpl;
import com.example.chat1.metier.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class UserCreationServlet extends HttpServlet {
    private UserDaoImpl userDAO;

    public void init() {
        userDAO = new UserDaoImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        String sessionID = session.getId();
        User user = new User();
        user.setName(username);
        user.setSessionID(sessionID);
        userDAO.addUser(user);
        request.setAttribute("userID", user.getId_user());
        request.getRequestDispatcher("/chat1.jsp").forward(request, response);
    }
    public void destroy() {
    }
}
