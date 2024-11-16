package com.org.entity;

public class User {
    
    private int id;
    private String fullname;
    private String email;
    private String password;
    private int age; 
    private String gender; 
    private String phno; 

    // Constructor with parameters
    public User(String fullname, String email, String password, int age, String gender, String phno) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phno = phno; 
    }

    // No-arg constructor
    public User() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhno() {
        return phno; 
    }

    public void setPhno(String phno) {
        this.phno = phno; 
    }
}
