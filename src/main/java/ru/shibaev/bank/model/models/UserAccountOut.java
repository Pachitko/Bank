package ru.shibaev.bank.model.models;

import java.math.BigDecimal;

public class UserAccountOut {
    public BigDecimal money;

    public String currency;

    public UserAccountOut(BigDecimal money, String currency) {
        this.money = money;
        this.currency = currency;
    }
}
