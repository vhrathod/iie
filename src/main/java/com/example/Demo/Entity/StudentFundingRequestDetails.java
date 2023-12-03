package com.example.Demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="STUDENT_FUNDING_REQUEST_DETAILS")
public class StudentFundingRequestDetails {

    @Id
    private String username;
    String fundingReason;
    long fundingAmount;
    String gpa;
    String Status;
    long eligableAmount;
}
