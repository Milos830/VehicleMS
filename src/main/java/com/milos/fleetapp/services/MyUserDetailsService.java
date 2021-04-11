package com.milos.fleetapp.services;

import com.milos.fleetapp.models.User;
import com.milos.fleetapp.models.UserPrincipal;
import com.milos.fleetapp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = userRepository.findByUsername(username);

       if(user == null) {
           throw new UsernameNotFoundException("User not found!");
       }


        return new UserPrincipal(user);
    }
}
