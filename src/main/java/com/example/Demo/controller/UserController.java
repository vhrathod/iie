package com.example.Demo.controller;

import com.example.Demo.Dto.*;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Entity.UserFundingRequestDetails;
import com.example.Demo.Exception.NotFoundException;
import com.example.Demo.Repository.UserRepository;
import com.example.Demo.Service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@Valid @RequestBody UserDto userDto){
         String result= userService.createAccount(userDto);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(result, result.equals("Success")?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }


    @PostMapping("/validate-otp")
    public ResponseEntity<Boolean> validateOtp(@RequestBody UserOtp userOpt){

        Optional<UserEntity> ue= userRepository.findByUsername(userOpt.getUserName());
        UserEntity u=ue.get();
        Boolean valid=userOpt.getOtp().equals(u.getOtp());
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(valid, valid==true?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @PostMapping("/fetchAllRequest")
    @SneakyThrows
    public ResponseEntity<List<UserRequestProjection>> fetchAllRequest(@RequestBody @Valid FetchRequest fetchRequest){
        userRepository.findByUsername(fetchRequest.getUsername()).orElseThrow(
                ()->new NotFoundException("User not found with username - "+fetchRequest.getUsername()));
        List<UserRequestProjection> list=userService.getAllRequestByUsername(fetchRequest.getUsername());
        return ResponseEntity.ok(list);
    }
    @PostMapping("/fetchRequest")
    @SneakyThrows
    public ResponseEntity<UserFundingRequestDetailsDto> fetchRequest(@RequestBody @Valid FetchRequest fetchRequest){
        userRepository.findByUsername(fetchRequest.getUsername()).orElseThrow(
                ()->new NotFoundException("User not found with username - "+fetchRequest.getUsername()));
        if(fetchRequest.getNameOfIdeaOrStartup()==null && fetchRequest.getUuid()==null){
            throw new NotFoundException("NameOfIdeaOrStartup or UUID is required");
        }
        UserFundingRequestDetailsDto dto=userService.getRequestByUserAndIdeaName(fetchRequest);
        return ResponseEntity.ok(dto);
    }
}
