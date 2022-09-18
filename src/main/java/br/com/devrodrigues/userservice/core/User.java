package br.com.devrodrigues.userservice.core;

public class User {

    private final Integer id;
    private final String name;
    private final String role;
    private final String password;

    public User(Integer id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return "";
    }
}