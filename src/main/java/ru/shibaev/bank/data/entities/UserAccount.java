package ru.shibaev.bank.data.entities;

import javax.persistence.*;

import lombok.Getter;

@Embeddable
public class UserAccount {
    @Getter
    private Long money;

    public UserAccount() {
    }

    public UserAccount(Long money) {
        this.money = money;
    }
}
