package com.example.Demo.Service;

import com.example.Demo.Dto.FetchRequest;
import com.example.Demo.Dto.UserDto;
import com.example.Demo.Dto.UserFundingRequestDetailsDto;
import com.example.Demo.Dto.UserRequestProjection;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Entity.UserFundingRequestDetails;
import com.example.Demo.Repository.UserFundingRequestDetailsRepository;
import com.example.Demo.Repository.UserRepository;
import com.example.Demo.UtilsFunctions.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFundingRequestDetailsRepository userFundingRequestDetailsRepository;

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

    @Override
    public List<UserRequestProjection> getAllRequestByUsername(String username) {
        return userFundingRequestDetailsRepository.findAllByUsername(username);
    }

    @Override
    public UserFundingRequestDetailsDto getRequestByUserAndIdeaName(FetchRequest fetchRequest) {
        UserFundingRequestDetails userFundingRequestDetails;
        if(fetchRequest.getNameOfIdeaOrStartup()!=null && fetchRequest.getUuid()!=null){
            userFundingRequestDetails=userFundingRequestDetailsRepository.findByNameOfIdeaOrStartupAndUuid(
                    fetchRequest.getNameOfIdeaOrStartup(),fetchRequest.getUuid());
        } else if (fetchRequest.getNameOfIdeaOrStartup()!=null) {
            userFundingRequestDetails=userFundingRequestDetailsRepository.findByNameOfIdeaOrStartup(
                    fetchRequest.getNameOfIdeaOrStartup());
        }else {
            userFundingRequestDetails=userFundingRequestDetailsRepository.findByUuid(fetchRequest.getUuid());
        }
        return userFundingRequestDetails.toDto();
    }

    @Override
    public UserFundingRequestDetailsDto saveFundRequest(UserFundingRequestDetailsDto dto) {
        UserFundingRequestDetails userFundingRequestDetails=dto.toEntity();
        return userFundingRequestDetailsRepository.save(userFundingRequestDetails).toDto();
    }


}
