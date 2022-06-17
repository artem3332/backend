package com.example.backend.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PutUserResponse {

    private Long login;
    private List<String> stringList;
}
