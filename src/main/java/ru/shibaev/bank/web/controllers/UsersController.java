package ru.shibaev.bank.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.shibaev.bank.data.repositories.UsersRepository;
import ru.shibaev.bank.data.entities.*;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository _usersRepository;

    @GetMapping("/users")
    public List<User> listAll() {
        List<User> users = _usersRepository.findAll();
        return users;
    }

}