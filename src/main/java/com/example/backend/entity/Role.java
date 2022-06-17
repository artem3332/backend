package com.example.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Data
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "user_id")
    private Long userId;

    public Role(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }
}
