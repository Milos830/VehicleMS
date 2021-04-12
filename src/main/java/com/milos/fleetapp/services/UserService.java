package com.milos.fleetapp.services;

import com.milos.fleetapp.models.User;
import com.milos.fleetapp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserService(BCryptPasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    public void save(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }
}
