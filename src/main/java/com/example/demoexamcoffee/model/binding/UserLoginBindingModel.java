package com.example.demoexamcoffee.model.binding;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel() {
    }
    @Size(min = 5, max = 20, message = "The length of the username must be between 5 and 20 characters!!!!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min = 4, message = "The length of the password must be more than 3!!!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
