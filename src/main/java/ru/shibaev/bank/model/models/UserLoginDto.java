package ru.shibaev.bank.model.models;

import lombok.*;

public class UserLoginDto {

    @Getter
    private String login;

    @Getter
    private String password;

    public UserLoginDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
