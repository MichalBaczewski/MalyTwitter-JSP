package com.example.mvc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Post implements Serializable {
    private Long id;
    private User publisher;
    private LocalDateTime postDateTime;
    private String message;

    public Post() {
    }

    public Post(Long id, User publisher, LocalDateTime postDateTime, String message) {
        this.id = id;
        this.publisher = publisher;
        this.postDateTime = postDateTime;
        this.message = message;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(publisher, post.publisher) &&
                Objects.equals(postDateTime, post.postDateTime) &&
                Objects.equals(message, post.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisher, postDateTime, message);
    }
}
