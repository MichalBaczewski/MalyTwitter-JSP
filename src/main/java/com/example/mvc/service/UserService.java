package com.example.mvc.service;

import com.example.Database;
import com.example.mvc.model.User;

import java.util.*;

public class UserService {

    private List<User> users;

    public UserService() {
        this.users = Database.getInstance().getUsers();
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserByLoginData(String login, String password) {
        return users.stream().filter(user -> userExists(login, password, user)).findFirst();
    }

    private boolean userExists(String login, String password, User user) {
        return user.getLogin().equals(login) && user.getPassword().equals(password);
    }
}
