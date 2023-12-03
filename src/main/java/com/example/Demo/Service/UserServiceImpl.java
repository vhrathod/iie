package com.example.Demo.Service;

import com.example.Demo.Dto.UserDto;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Package.UserMapper;
import com.example.Demo.Repository.UserRepository;
import com.example.Demo.UtilsFunctions.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    @Override
    public String createAccount(UserDto userDto){
        try {
            UserEntity userEntity= new UserEntity();
            userEntity.setRole(userDto.getRole());
            userEntity.setName(userDto.getName());
            userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userEntity.setUsername(userDto.getUserName());
            userEntity.setPhoneNumber(userDto.getPhoneNumber());
            String opt=Utils.generateOtp();
            userEntity.setOtp(opt);
            userRepository.save(userEntity);
            emailService.sendEmail(userDto.getUserName(),opt,userDto.getName());
        }catch(Exception e){
            return "Failure";
        }
        return "Success";
    }



}
