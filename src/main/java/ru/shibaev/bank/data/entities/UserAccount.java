package ru.shibaev.bank.data.entities;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Getter;

@Embeddable
public class UserAccount {

    @Getter
    private BigDecimal money;

    @Getter
    private String currency;

    public UserAccount() {
    }

    public UserAccount(String currency, BigDecimal money) {
        this.money = money;
    }
}
