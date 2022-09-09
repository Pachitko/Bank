package ru.shibaev.bank.data.entities;

import java.util.UUID;

import javax.persistence.*;

import lombok.Getter;

@Entity
@Table(name = "user_account_transacations")
public class UserAccountTransaction {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private UUID fromUserAccountId;

    @Getter
    private UUID toUserAccountId;

    public UserAccountTransaction() {
    }

    public UserAccountTransaction(UUID fromUserAccountId, UUID toUserAccountId) {
        this.fromUserAccountId = fromUserAccountId;
        this.toUserAccountId = toUserAccountId;
    }
}
