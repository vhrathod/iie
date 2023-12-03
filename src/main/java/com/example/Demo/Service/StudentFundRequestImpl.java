package com.example.Demo.Service;

import com.example.Demo.Dto.StudentFundingRequestDetailsDto;
import com.example.Demo.Entity.StudentFundingRequestDetails;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Exception.NotFoundException;
import com.example.Demo.Repository.StudentFundingRequestDetailsRepository;
import com.example.Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentFundRequestImpl implements StudentFundRequest{

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentFundingRequestDetailsRepository studentFundingRequestDetailsRepository;

    @Override
    public UserEntity validateRequestAndSendUniName(StudentFundingRequestDetailsDto studentFundingRequestDetailsDto) throws NotFoundException {
        Optional<UserEntity> uE = userRepository.findByUsername(studentFundingRequestDetailsDto.getUsername());
        if(!uE.isPresent())
            throw new NotFoundException("User not found!!");

        StudentFundingRequestDetails sfrd=new StudentFundingRequestDetails();
        sfrd.setFundingAmount(studentFundingRequestDetailsDto.getFundingAmount());
        sfrd.setFundingReason(studentFundingRequestDetailsDto.getFundingReason());
        sfrd.setUsername(studentFundingRequestDetailsDto.getUsername());
        sfrd.setGpa(studentFundingRequestDetailsDto.getGpa());
        sfrd.setStatus("PENDING");

        studentFundingRequestDetailsRepository.save(sfrd);
           return uE.get();
    }
}
