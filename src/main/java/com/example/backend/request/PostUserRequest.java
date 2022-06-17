package com.example.backend.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostUserRequest {


    private Long login;

    private String name;

    private String password;

    private List<String> roleList;


}
