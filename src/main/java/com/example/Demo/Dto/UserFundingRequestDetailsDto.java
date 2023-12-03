package com.example.Demo.Dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserFundingRequestDetailsDto {

     private UUID uuid;
     private String username;
     private String userQualification;
     private String qualifiedFromUniversity;
     private String gpaOfUser;
     private String usersInvestmentInIdea; //ownerOfIdea, InvestedCapital,
     private String investedCapitalByUser;
     private String percentageOwnershipOfUser;

     private String nameOfIdeaOrStartup;
     private String inspirationOfIdea;
     private String initialCapitalInIdea;
     private String domainOfIdea;
     private String ideaOrStartupStage;// idea, implementation, operational
     private String ideaOrStartupFinancialStage;// burning, breakeven, profitable
     private String typeOfIdeaOrStartup; // service, product
     private String ideaDescription;
     private String startDate;
     private String fundingAmtRequired;
     private int activeUserCount;

     private String fundingReason;
     private List<String> financialDoc;
     private String comment;
     private String status; // submitted, screening, investorReview, inprocess, rejected, approved
     private String eligibleAmtByInvestor;
}
