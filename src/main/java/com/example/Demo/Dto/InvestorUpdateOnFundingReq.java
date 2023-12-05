package com.example.Demo.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class InvestorUpdateOnFundingReq {

    private UUID uuidOfIdea;
    private String nameOfIdeaOrStartup;
    private String investorName;
    private String comment;
    private BigDecimal eligibleAmtByInvestor;
    private int ratingFrom5;
}
