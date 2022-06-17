package com.example.backend.repository;

import com.example.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Modifying
    void deleteByUserId(Long login);

}
