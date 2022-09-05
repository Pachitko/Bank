package ru.shibaev.bank.data;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ru.shibaev.bank.data.entities.User;
import ru.shibaev.bank.data.entities.UserAccount;
import ru.shibaev.bank.data.repositories.UsersRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }

    private void seedDatabase() {
        if (usersRepository.count() == 0) {
            User user1 = new User("user1", "mail1@mail.ru", "Password1", new UserAccount("RUB", new BigDecimal(100)));
            User user2 = new User("user2", "mail2@mail.ru", "Password2", new UserAccount("RUB", new BigDecimal(200)));
            usersRepository.save(user1);
            usersRepository.save(user2);
            usersRepository.flush();
        }

        System.out.println(usersRepository.count());
    }
}
