package com.example.Demo.Service;

import com.example.Demo.Dto.*;

import java.util.List;

public interface UserService {

    public String createAccount(UserDto userDto);

    List<UserRequestProjection> getAllRequestByUsername(String username);

    UserFundingRequestDetailsDto getRequestByUserAndIdeaName(FetchRequest fetchRequest);

    UserFundingRequestDetailsDto saveFundRequest(UserFundingRequestDetailsDto dto);

    String updateUserFundingReq(InvestorUpdateOnFundingReq dto);
}
