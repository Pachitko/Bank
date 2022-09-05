package ru.shibaev.bank.data.entities;

import java.util.UUID;

import javax.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Getter
    private String login;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    @Embedded
    private UserAccount account;

    public User() {
    }

    public User(String login, String email, String password, UserAccount account) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.account = account;
    }
}
