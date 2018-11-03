package com.example.mvc.service;

import com.example.Database;
import com.example.mvc.model.Post;
import com.example.mvc.model.User;

import java.util.List;
import java.util.Optional;

public class PostService {

    private List<Post> posts;

    public PostService() {
        this.posts = Database.getInstance().getPosts();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public boolean removePost(Long id) {
        Optional<Post> optPost = posts.stream().filter(post -> post.getId().equals(id)).findFirst();
        optPost.ifPresent(post -> posts.remove(post));
        return optPost.isPresent();
    }
}
