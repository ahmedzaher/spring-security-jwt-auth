package com.example.auth.jwt.service;

import com.example.auth.jwt.configuration.SystemUserDetails;
import com.example.auth.jwt.model.SystemUser;
import com.example.auth.jwt.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUser> user = systemUserRepository.findByUsername(username);

        user.orElseThrow( () -> new UsernameNotFoundException("User not found"));

        return user.map(SystemUserDetails::new).get();
    }

}
