package ru.shibaev.bank.web.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.shibaev.bank.model.models.*;
import ru.shibaev.bank.model.services.UserManager;

@RestController
// todo: use global CORS for angular
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class UsersController {

    @Autowired
    private UserManager userManager;

    @GetMapping("/users")
    @ResponseBody
    public Response<List<UserOut>> getAllUsers() {
        return Response.Ok(userManager.getAllUsers());
    }

    @PostMapping("/users")
    private void addUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        userManager.createUser(userRegistrationDto);
    }
}