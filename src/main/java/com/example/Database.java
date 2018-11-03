package com.example;

import com.example.mvc.model.Gender;
import com.example.mvc.model.Post;
import com.example.mvc.model.Role;
import com.example.mvc.model.User;
import com.example.mvc.service.UserService;
import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Database {

    private List<User> users;
    private List<Post> posts;
    private static Database instance = null;

    private Database() {
        this.users = initUsers();
        this.posts = initPosts();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private List<User> initUsers() {
        List<User> result = Lists.newArrayList();
        result.add(new User(1L, "user", "user", Role.ROLE_USER, "Jan", "jan123@mail", LocalDate.of(1990, 5, 18), Gender.MALE, true));

        result.add(new User(2L, "test", "test", Role.ROLE_USER, "Piotr", "piotr11@mail", LocalDate.of(1982, 2, 27), Gender.MALE, true));

        result.add(new User(3L, "admin", "admin", Role.ROLE_ADMIN, "Anna", "anna11@mail", LocalDate.of(1982, 8, 3), Gender.FEMALE, false));
        return result;
    }


    private List<Post> initPosts() {
        List<Post> result = Lists.newArrayList();
        result.add(new Post(1L, users.get(0), LocalDateTime.of(2017,8, 2, 2, 2), "Pierwszy post"));
        result.add(new Post(2L, users.get(1), LocalDateTime.of(2017,8, 2, 2, 2), "Drugi post"));
        result.add(new Post(3L, users.get(2), LocalDateTime.of(2017,8, 2, 2, 2), "Trzeci post"));
        return result;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Post> getPosts() {
        return posts;
    }


}
