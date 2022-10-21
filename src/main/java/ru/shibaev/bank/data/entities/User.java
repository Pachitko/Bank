package ru.shibaev.bank.data.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import lombok.Getter;
import ru.shibaev.bank.model.models.UserAccountOut;
import ru.shibaev.bank.model.models.UserOut;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID id;

    @Getter
    @Column(unique = true)
    private String username;

    @Getter
    @Column(unique = true)
    private String email;

    @Getter
    private String password;

    @Getter
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<UserAccount> accounts;

    public User() {
    }

    public User(String username, String email, String password, List<UserAccount> accounts) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
    }

    public UserOut toDto() {
        var userAccounts = new ArrayList<UserAccountOut>();
        for (UserAccount userAccount : accounts) {
            userAccounts.add(userAccount.toDto());
        }
        var userDto = new UserOut(username, email, userAccounts);

        return userDto;
    }
}
