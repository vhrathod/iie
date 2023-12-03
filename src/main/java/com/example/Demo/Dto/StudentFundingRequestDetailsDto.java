package com.example.Demo.Dto;

import lombok.Data;

@Data
public class StudentFundingRequestDetailsDto {
     String username;
     String fundingReason;
     long fundingAmount;
     String gpa;
     String status;
     long eligableAmount;

}
