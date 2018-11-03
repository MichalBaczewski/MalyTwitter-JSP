package com.example.mvc.controller;

import com.example.mvc.model.Post;
import com.example.mvc.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "deletePostServlet", urlPatterns = "/deletePost")
public class DeletePostServlet extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        this.postService = new PostService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        postService.removePost(id);
        req.getRequestDispatcher("").forward(req, resp);
    }

}
