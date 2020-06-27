package com.metacube.training;

public class Person {
    private String type;

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void checkType() {
        System.out.println(type);
    }
}