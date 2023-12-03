package com.example.Demo.Entity;

import com.example.Demo.Dto.UserFundingRequestDetailsDto;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name="USER_FUNDING_REQUEST_DETAILS")
public class UserFundingRequestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String username;
    private String userQualification;
    private String qualifiedFromUniversity;
    private String gpaOfUser;
    private String usersInvestmentInIdea; //ownerOfIdea, InvestedCapital,
    private BigDecimal investedCapitalByUser;
    private String percentageOwnershipOfUser;

    @Column(unique = true)
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
    @Lob
    private List<String> financialDoc;
    private String comment;
    private String status; // submitted, screening, investorReview, inprocess, rejected, approved
    private BigDecimal eligibleAmtByInvestor;
    private int ratingFrom5;


    public UserFundingRequestDetailsDto toDto(){
        UserFundingRequestDetailsDto dto=new UserFundingRequestDetailsDto();
        dto.setUuid(this.uuid);
        dto.setUsername(this.username);
        dto.setUserQualification(userQualification);
        dto.setQualifiedFromUniversity(qualifiedFromUniversity);
        dto.setGpaOfUser(gpaOfUser);
        dto.setUsersInvestmentInIdea (usersInvestmentInIdea );
        dto.setInvestedCapitalByUser(investedCapitalByUser);
        dto.setPercentageOwnershipOfUser(percentageOwnershipOfUser);
        dto.setNameOfIdeaOrStartup(nameOfIdeaOrStartup);
        dto.setInspirationOfIdea(inspirationOfIdea);
        dto.setInitialCapitalInIdea(initialCapitalInIdea);
        dto.setDomainOfIdea(domainOfIdea);
        dto.setIdeaOrStartupStage(ideaOrStartupStage);
        dto.setIdeaOrStartupFinancialStage(ideaOrStartupFinancialStage);
        dto.setTypeOfIdeaOrStartup (typeOfIdeaOrStartup );
        dto.setIdeaDescription(ideaDescription);
        dto.setStartDate(startDate);
        dto.setFundingAmtRequired(fundingAmtRequired);
        dto.setActiveUserCount(activeUserCount);
        dto.setFundingReason(fundingReason);
        dto.setFinancialDoc(financialDoc);
        dto.setComment(comment);
        dto.setStatus (status );
        dto.setEligibleAmtByInvestor(eligibleAmtByInvestor);
        dto.setRatingFrom5(ratingFrom5);
        return dto;
    }
}
