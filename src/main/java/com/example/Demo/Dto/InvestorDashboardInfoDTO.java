package com.example.Demo.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvestorDashboardInfoDTO {

    String Name;
    String universityName;
    String reasonForFunding;
    String gpa;
    BigDecimal fundingAmount;
}
