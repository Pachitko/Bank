package ru.shibaev.bank.model.models;

import lombok.*;

public class UserRegistrationDto {

    @Getter
    private String login;

    @Getter
    private String email;

    @Getter
    private String password;

    public UserRegistrationDto(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }
}
