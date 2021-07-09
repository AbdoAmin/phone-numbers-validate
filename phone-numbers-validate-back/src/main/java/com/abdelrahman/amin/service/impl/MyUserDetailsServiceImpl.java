package com.abdelrahman.amin.service.impl;

import com.abdelrahman.amin.entity.User;
import com.abdelrahman.amin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getUsername(), user.isEnabled(), true, true, true,
                user.getAuthorities().stream()
                        .map((authority) -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList()));
    }
}