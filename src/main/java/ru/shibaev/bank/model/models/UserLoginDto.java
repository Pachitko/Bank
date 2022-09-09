package ru.shibaev.bank.model.models;

public class UserLoginDto {

    public String login;
    public String password;

    public UserLoginDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
