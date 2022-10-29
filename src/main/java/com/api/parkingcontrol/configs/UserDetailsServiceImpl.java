package com.api.parkingcontrol.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.User;
import com.api.parkingcontrol.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) 
        throws UsernameNotFoundException {

        User user = repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
        
            return user;
    }
    
}
