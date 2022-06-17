package com.example.backend.controller;

import com.example.backend.request.GetUserResponse;
import com.example.backend.request.PostUserRequest;
import com.example.backend.request.PutUserResponse;
import com.example.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PostUserRequest postUserRequest) {

        try {
            log.info("Create User");
            userService.createUser(postUserRequest);
            return ResponseEntity.ok("Пользователь успешно создан!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        try {
            log.info("Find All Users");
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/userById")
    public ResponseEntity<?> userById(@RequestBody GetUserResponse getUserResponse) {

        try {
            log.info("User By Id");
            System.out.println(getUserResponse.getLogin());
            return ResponseEntity.ok(userService.userById(getUserResponse.getLogin()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/userDeleteById")
    public ResponseEntity<?> userDeleteById(@RequestBody GetUserResponse getUserResponse) {

        try {
            log.info("User Delete By Id");
            userService.userDeleteById(getUserResponse.getLogin());
            return ResponseEntity.ok("Пользователь успешно удален!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/userPutById")
    public ResponseEntity<?> userPutById(@RequestBody PutUserResponse putUserResponse) {

        try {
            log.info("User Put By Id");
            userService.userPutById(putUserResponse);
            return ResponseEntity.ok("Пользователь успешно изменён!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
