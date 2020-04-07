package com.example.auth.jwt.repository;

import com.example.auth.jwt.model.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

    public Optional<SystemUser> findByUsername(String username);
}
