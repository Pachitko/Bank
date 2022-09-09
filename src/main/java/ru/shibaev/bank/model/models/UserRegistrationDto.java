package ru.shibaev.bank.model.models;

import java.util.Collections;

import ru.shibaev.bank.data.entities.User;

public class UserRegistrationDto {

    public String username;
    public String email;
    public String password;

    public UserRegistrationDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User toUser() {
        return new User(username, email, password, Collections.emptyList());
    }
}
