package com.example.mvc.controller;

import com.example.mvc.model.Message;
import com.example.mvc.service.UserService;
import com.example.mvc.model.User;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "userServlet", urlPatterns = "/users/*")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo();

        if (isGetUsersRequest(path)) {
            List<User> users = userService.getUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } else if (isGetUserByIdRequest(path)) {
            Long id = getIdFromPath(path);
            Optional<User> user = userService.getUserById(id);
            if (user.isPresent()) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("/user.jsp").forward(req, resp);
            } else {
                String value = "Nie udało się znaleść użytkownika o id = " + id;
                req.setAttribute("message", new Message(value, Message.Type.ERROR));
                req.getRequestDispatcher("/404.jsp").forward(req, resp);
            }
        } else {
            String value = "Taka strona nie istnieje!";
            req.setAttribute("message", new Message(value, Message.Type.ERROR));
            req.getRequestDispatcher("/404.jsp").forward(req, resp);
        }
    }

    private Long getIdFromPath(String pathInfo) {
        List<String> pathParts = getPathParts(pathInfo);
        return Longs.tryParse(pathParts.get(0));
    }

    private boolean isGetUserByIdRequest(String path) {
        List<String> pathParts = getPathParts(path);
        return pathParts.size() == 1 && Longs.tryParse(pathParts.get(0)) != null;
    }

    private boolean isGetUsersRequest(String path) {
        return path == null || path.equals("/");
    }

    private List<String> getPathParts(String path) {
        List<String> pathParts = Lists.newArrayList();
        if (path != null) {
            pathParts = Lists.newArrayList(path.split("/"));
            pathParts.removeIf(String::isEmpty);
        }
        return pathParts;
    }
}
