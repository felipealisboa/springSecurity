package org.felipeLx.springSecurity.security.service;

import org.felipeLx.springSecurity.model.User;
import org.felipeLx.springSecurity.repository.UserRepository;
import org.felipeLx.springSecurity.security.service.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException("User not found with -> username or email : " + username));
            return UserPrinciple.build(user);
        }
    }

