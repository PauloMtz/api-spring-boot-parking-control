package com.api.parkingcontrol.configs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.api.parkingcontrol.models.UserModel;
import com.api.parkingcontrol.repositories.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) 
        throws UsernameNotFoundException {

        UserModel user = repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
        
            return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
    }
    
}
