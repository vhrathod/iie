package com.example.Demo.controller;

import com.example.Demo.Dto.UserDto;
import com.example.Demo.Dto.UserOtp;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Repository.UserRepository;
import com.example.Demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@Valid @RequestBody UserDto userDto){
         String result= userService.createAccount(userDto);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(result, result.equals("Success")?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/validate-otp")
    public ResponseEntity<Boolean> validateOtp(@RequestBody UserOtp userOpt){

        Optional<UserEntity> ue= userRepository.findByUsername(userOpt.getUserName());
        UserEntity u=ue.get();
        Boolean valid=userOpt.getOtp().equals(u.getOtp());
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(valid, valid==true?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
