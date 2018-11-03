package com.example.mvc.controller;

import com.example.mvc.model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        String value = "Zostałeś poprawnie wylogowany!";
        req.setAttribute("message", new Message(value, Message.Type.SUCCESS));
        req.getRequestDispatcher("/posts").forward(req, resp);
    }
}
