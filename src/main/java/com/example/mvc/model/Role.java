package com.example.mvc.model;

public enum Role {
    ROLE_USER("Użytkownik"),
    ROLE_ADMIN("Administrator");

    private String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
