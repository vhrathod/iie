package com.example.Demo.Dto;

import com.example.Demo.Entity.UserFundingRequestDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFundingRequestDetailsDto {

     private UUID uuid;
     @NotEmpty(message = "Username is required")
     private String username;
     @NotEmpty(message = "User qualification is required")
     private String userQualification;
     @NotEmpty(message = "University of user is required")
     private String qualifiedFromUniversity;
     @NotEmpty(message = "GPA of user is required")
     private String gpaOfUser;
     @NotEmpty(message = "UserInvestmentInIdea is required")
     private String usersInvestmentInIdea; //ownerOfIdea, InvestedCapital,
     @NotEmpty(message = "InvestedCapitalByUser is required")
     private BigDecimal investedCapitalByUser;
     @NotEmpty(message = "percentageOwnershipOfUser is required")
     private String percentageOwnershipOfUser;

     @NotEmpty(message = "NameOfIdeaOrStartup is required")
     private String nameOfIdeaOrStartup;
     @NotEmpty(message = "inspirationOfIdea is required")
     private String inspirationOfIdea;
     @NotEmpty(message = "initialCapitalInIdea is required")
     private BigDecimal initialCapitalInIdea;
     @NotEmpty(message = "domainOfIdea is required")
     private String domainOfIdea;
     @NotEmpty(message = "ideaOrStartupStage is required")
     private String ideaOrStartupStage;// idea, implementation, operational
     @NotEmpty(message = "ideaOrStartupFinancialStage is required")
     private String ideaOrStartupFinancialStage;// burning, breakeven, profitable
     @NotEmpty(message = "typeOfIdeaOrStartup is required")
     private String typeOfIdeaOrStartup; // service, product
     @NotEmpty(message = "ideaDescription is required")
     private String ideaDescription;
     @NotEmpty(message = "startDate is required")
     private String startDate;
     @NotEmpty(message = "fundingAmtRequired is required")
     private BigDecimal fundingAmtRequired;
     @NotEmpty(message = "activeUserCount is required")
     private int activeUserCount;

     private String investorName;
     private String fundingReason;
     private List<String> financialDoc;
     private String comment;
     private String status; // submitted, screening, investorReview, inprocess, rejected, approved
     private BigDecimal eligibleAmtByInvestor;
     private int ratingFrom5;


     public UserFundingRequestDetails toEntity(){
          UserFundingRequestDetails entity=new UserFundingRequestDetails();
          entity.setUuid(this.uuid);
          entity.setUsername(this.username);
          entity.setUserQualification(userQualification);
          entity.setQualifiedFromUniversity(qualifiedFromUniversity);
          entity.setGpaOfUser(gpaOfUser);
          entity.setUsersInvestmentInIdea (usersInvestmentInIdea );
          entity.setInvestedCapitalByUser(investedCapitalByUser);
          entity.setPercentageOwnershipOfUser(percentageOwnershipOfUser);
          entity.setNameOfIdeaOrStartup(nameOfIdeaOrStartup);
          entity.setInspirationOfIdea(inspirationOfIdea);
          entity.setInitialCapitalInIdea(initialCapitalInIdea);
          entity.setDomainOfIdea(domainOfIdea);
          entity.setIdeaOrStartupStage(ideaOrStartupStage);
          entity.setIdeaOrStartupFinancialStage(ideaOrStartupFinancialStage);
          entity.setTypeOfIdeaOrStartup (typeOfIdeaOrStartup );
          entity.setIdeaDescription(ideaDescription);
          entity.setStartDate(startDate);
          entity.setFundingAmtRequired(fundingAmtRequired);
          entity.setActiveUserCount(activeUserCount);
          entity.setInvestorName(this.investorName);
          entity.setFundingReason(fundingReason);
          entity.setFinancialDoc(financialDoc);
          entity.setComment(comment);
          entity.setStatus (status );
          entity.setEligibleAmtByInvestor(eligibleAmtByInvestor);
          entity.setRatingFrom5(ratingFrom5);
          return entity;
     }
}
