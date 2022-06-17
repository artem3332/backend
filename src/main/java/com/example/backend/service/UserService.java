package com.example.backend.service;

import com.example.backend.entity.Role;
import com.example.backend.entity.Users;
import com.example.backend.repository.RoleRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.request.PostUserRequest;
import com.example.backend.request.PutUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public void createUser(PostUserRequest postUserRequest) throws Exception {

        String password = postUserRequest.getPassword();


        int req1 = 0;
        int req2 = 0;
        for (int i = 0; i < password.length(); i++) {

            if (Character.isUpperCase(password.charAt(i))) {
                req1++;
            }

            if (Character.isDigit(password.charAt(i))) {
                req2++;
            }

        }

        if (req1 > 1 || req2 > 1 || req1 < 1 || req2 < 1) {
            throw new Exception("Пароль должен содержать 1 заглавную букву и 1 цифру");
        }


        Users user = new Users(postUserRequest.getLogin(), postUserRequest.getName(), postUserRequest.getPassword());

        userRepository.save(user);

        List<Role> list = new ArrayList<>();

        for (String role : postUserRequest.getRoleList()) {

            Role role1 = new Role(role, postUserRequest.getLogin());
            list.add(role1);

        }

        roleRepository.saveAll(list);

    }

    public List<Users> findAll() {
        return userRepository.findAllUsers();
    }

    public Users userById(Long login) {
        return userRepository.findById(login).get();
    }

    public void userDeleteById(Long login) {


        Users users = userRepository.findById(login).get();

        users.getRoles().stream().forEach(p -> roleRepository.deleteById(p.getId()));

        userRepository.deleteById(login);


    }

    @Transactional
    public void userPutById(PutUserResponse putUserResponse) {

        putUserResponse.getStringList().stream().forEach(p -> roleRepository.deleteByUserId(putUserResponse.getLogin()));


        List<Role> list = new ArrayList<>();

        for (String role : putUserResponse.getStringList()) {

            Role role1 = new Role(role, putUserResponse.getLogin());
            list.add(role1);

        }

        roleRepository.saveAll(list);


    }


}
