package com.example.mvc.controller;

import com.example.mvc.model.Message;
import com.example.mvc.model.User;
import com.example.mvc.service.PostService;
import com.example.mvc.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;

@WebServlet(name="login", value = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    private PostService postService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
        this.postService = new PostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> optUser = userService.getUserByLoginData(login, password);
        if (optUser.isPresent()) {
            User user = optUser.get();
            req.getSession().setAttribute("user", user);
            String value = "Zostałeś poprawnie zalogowany!";
            req.setAttribute("message", new Message(value, Message.Type.SUCCESS));
        } else {
            String value = "Nie znaleziono takiego użytkownika!";
            req.setAttribute("message", new Message(value, Message.Type.ERROR));
        }
        req.getRequestDispatcher("/posts").forward(req, resp);
    }

}