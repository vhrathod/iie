package com.example.Demo.controller;

import com.example.Demo.Dto.StudentFundingRequestDetailsDto;
import com.example.Demo.Entity.UniversityToUniversityEMailMapper;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Exception.NotFoundException;
import com.example.Demo.Exception.ProcessingException;
import com.example.Demo.Repository.StudentFundingRequestDetailsRepository;
import com.example.Demo.Repository.UniversityTouniversityEmailMapperRepository;
import com.example.Demo.Repository.UserRepository;
import com.example.Demo.Service.EmailService;
import com.example.Demo.Service.StudentFundRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class FundRequestController {

    @Autowired
    EmailService emailService;

    @Autowired
    StudentFundingRequestDetailsRepository studentFundingRequestDetailsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentFundRequest studentFundRequest;

    @Autowired
    UniversityTouniversityEmailMapperRepository universityTouniversityEmailMapperRepository;

    @PostMapping("/request")
    public ResponseEntity<String> IntitateFundingProcess(@RequestBody StudentFundingRequestDetailsDto fundRequest) throws ProcessingException {
        try {

           UserEntity userEntity= studentFundRequest.validateRequestAndSendUniName(fundRequest);
           if(null==userEntity)
               throw new NotFoundException("The Universtiy does not exist!!");

//           if(!userEntity.getUniversityName().equalsIgnoreCase("FIU")) {
//               Optional<UniversityToUniversityEMailMapper> universityToUniversityEMailMapper = universityTouniversityEmailMapperRepository.findById(userEntity.getUniversityName());
//               if (!universityToUniversityEMailMapper.isPresent())
//                   throw new NotFoundException("The university Email does not exist!!");
//           }

//            emailService.sendEmail("adoniabhishek9@gmail.com",userEntity.getHashValue(),userEntity.getOtp(),userEntity.getName());
        }catch (Exception e){
            throw new ProcessingException("Exception occured while sending email");
        }
        return new ResponseEntity<>("Email Sent to University",HttpStatus.OK);
    }

    @GetMapping("/verify")
    public ResponseEntity<?> ValidateUniApproval(@RequestParam("hash") String hash,
                                                 @RequestParam("otp") String otp) throws NotFoundException, ProcessingException {

       Optional<UserEntity> user= null;

       if(!user.isPresent())
           throw new NotFoundException("The combination entry not found");

        try {
            studentFundingRequestDetailsRepository.updateVerifiedStatus(user.get().getUsername(), "Uni_verified");
        }catch (Exception e){
            throw new ProcessingException("Uanblet to update the status");
        }
        return new ResponseEntity<>("Student verifed",HttpStatus.OK);
    }

}
