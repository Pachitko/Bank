package ru.shibaev.bank.model.models;

import java.util.List;

public class UserOut {
    public String username;

    public String email;

    public List<UserAccountOut> accounts;

    public UserOut(String username, String email, List<UserAccountOut> accounts) {
        this.username = username;
        this.email = email;
    }
}
