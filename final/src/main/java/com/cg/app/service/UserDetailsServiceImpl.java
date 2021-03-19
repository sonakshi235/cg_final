package com.cg.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.app.config.UserPrinciple;
import com.cg.app.dao.UserRepository;
import com.cg.app.model.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.of(userRepository.findOne(username));
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Username or Password mismatched");
        }
       return new UserPrinciple(user.get());
    }
}
