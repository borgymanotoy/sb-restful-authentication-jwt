package com.ploverbay.ticketing.authentication.service;

import com.ploverbay.ticketing.authentication.model.User;
import com.ploverbay.ticketing.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Service for loading user details by username/email
 *
 * @author Eric Jose E. Salip Ahmad
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository m_userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User applicationUser = m_userRepository.findByEmail(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(applicationUser.getEmailAddress(),
                        applicationUser.getPassword(), Collections.emptyList());

        return user;
    }

}