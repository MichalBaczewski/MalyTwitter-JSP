package com.example.mvc.model;

public class Message {
    private String value;
    private Type type;

    public Message(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        INFO,
        SUCCESS,
        WARNING,
        ERROR
    }
}
