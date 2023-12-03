package com.example.Demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFundingRequestDetailsDto {

     private UUID uuid;
     private String username;
     private String userQualification;
     private String qualifiedFromUniversity;
     private String gpaOfUser;
     private String usersInvestmentInIdea; //ownerOfIdea, InvestedCapital,
     private BigDecimal investedCapitalByUser;
     private String percentageOwnershipOfUser;

     private String nameOfIdeaOrStartup;
     private String inspirationOfIdea;
     private BigDecimal initialCapitalInIdea;
     private String domainOfIdea;
     private String ideaOrStartupStage;// idea, implementation, operational
     private String ideaOrStartupFinancialStage;// burning, breakeven, profitable
     private String typeOfIdeaOrStartup; // service, product
     private String ideaDescription;
     private String startDate;
     private BigDecimal fundingAmtRequired;
     private int activeUserCount;

     private String fundingReason;
     private List<String> financialDoc;
     private String comment;
     private String status; // submitted, screening, investorReview, inprocess, rejected, approved
     private BigDecimal eligibleAmtByInvestor;
     private int ratingFrom5;
}
