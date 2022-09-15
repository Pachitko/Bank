package ru.shibaev.bank.model.models;

import java.math.BigDecimal;
import java.util.UUID;

public class UserAccountTransactionOut {

    public UUID fromUserAccountId;
    public UUID toUserAccountId;
    public BigDecimal amount;
    // todo currency

    public UserAccountTransactionOut(UUID fromUserAccountId, UUID toUserAccountId, BigDecimal amount) {
        this.fromUserAccountId = fromUserAccountId;
        this.toUserAccountId = toUserAccountId;
        this.amount = amount;
    }
}
