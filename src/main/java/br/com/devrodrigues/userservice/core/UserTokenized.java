package br.com.devrodrigues.userservice.core;

public class UserTokenized {
    private final String name;
    private final String role;

    public UserTokenized(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
