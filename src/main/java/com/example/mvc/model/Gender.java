package com.example.mvc.model;

public enum Gender {
    MALE("Pan"),
    FEMALE("Pani");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
