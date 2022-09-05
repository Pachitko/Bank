package ru.shibaev.bank.web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.shibaev.bank.data.repositories.UsersRepository;
import ru.shibaev.bank.model.models.*;
import ru.shibaev.bank.data.entities.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<?> getAllUsers() {
        List<UserOut> usersDtoOut = new ArrayList<>();

        for (var user : usersRepository.findAll()) {
            usersDtoOut.add(user.toDto());
        }

        return usersDtoOut;
    }

    @PostMapping("/users")
    void addUser(@RequestBody UserRegistrationDto user) {
        User newUser = new User(user.getLogin(), user.getEmail(), user.getPassword(), new ArrayList<UserAccount>());
        usersRepository.save(newUser);
    }
}