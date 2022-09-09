package ru.shibaev.bank.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.shibaev.bank.data.repositories.UsersRepository;
import ru.shibaev.bank.model.models.UserOut;
import ru.shibaev.bank.model.models.UserRegistrationDto;

@Component("userManager")
public class UserManager {

    @Autowired
    private UsersRepository usersRepository;

    public List<UserOut> getAllUsers() {
        List<UserOut> usersDtoOut = new ArrayList<>();

        for (var user : usersRepository.findAll()) {
            usersDtoOut.add(user.toDto());
        }

        return usersDtoOut;
    }

    public void createUser(UserRegistrationDto userRegistrationDto) {
        // todo: add exceptions
        usersRepository.save(userRegistrationDto.toUser());
    }
}
