package com.example.Demo.Service;

import com.example.Demo.Dto.CustomUserDetails;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

      return userEntity.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with username: "+username));

    }
}
