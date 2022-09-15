package ru.shibaev.bank.model.models;

import java.math.BigDecimal;
import java.util.UUID;

public class UserAccountTransactionIn {

    private String fromUserAccountId;

    public UUID getFromUserAccountId() {
        return UUID.fromString(fromUserAccountId);
    }

    private String toUserAccountId;

    public UUID getToUserAccountId() {
        return UUID.fromString(toUserAccountId);
    }

    private int amount;

    public BigDecimal getAmount() {
        return new BigDecimal(amount);
    }

}
