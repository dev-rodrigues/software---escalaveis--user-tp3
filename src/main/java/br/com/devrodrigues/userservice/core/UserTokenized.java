package br.com.devrodrigues.userservice.core;

public class UserTokenized {
    private String name;
    private String role;

    public UserTokenized() {
        //no-sonar
    }

    public UserTokenized(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
