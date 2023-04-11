package org.example.model.api;

public class User {
    private String email;
    private String password;
    private String name;


    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }
}

//allure serve target/surefire-reports/