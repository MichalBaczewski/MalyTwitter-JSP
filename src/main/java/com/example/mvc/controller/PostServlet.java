package com.example.mvc.controller;

import com.example.mvc.model.Message;
import com.example.mvc.model.Post;
import com.example.mvc.model.User;
import com.example.mvc.service.PostService;
import com.example.mvc.service.UserService;
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

@WebServlet(name = "postServlet", urlPatterns = {"/posts"})
public class PostServlet extends HttpServlet {

    private PostService postService;

    @Override
    public void init() throws ServletException {
        this.postService = new PostService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> posts = postService.getPosts();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> posts = postService.getPosts();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
