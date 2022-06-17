package com.example.backend.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
public class Users {

    @Id
    @NotNull
    private Long login;

    @NotNull
    private String name;

    @NotNull
    private String password;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public Users(Long login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }
}
