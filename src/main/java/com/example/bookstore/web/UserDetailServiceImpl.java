package com.example.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.AppUser;
import com.example.bookstore.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
        AppUser curruser = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(
            curruser.getUsername(),
            curruser.getPassword(),
            AuthorityUtils.createAuthorityList(curruser.getRole())
        );
    }
}
