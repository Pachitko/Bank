package ru.shibaev.bank.data.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.shibaev.bank.data.entities.UserAccountTransaction;

public interface UserAccountTransactionsRepositoy extends JpaRepository<UserAccountTransaction, UUID> {

}