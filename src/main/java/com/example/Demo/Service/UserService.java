package com.example.Demo.Service;

import com.example.Demo.Dto.FetchRequest;
import com.example.Demo.Dto.UserDto;
import com.example.Demo.Dto.UserFundingRequestDetailsDto;
import com.example.Demo.Dto.UserRequestProjection;

import java.util.List;

public interface UserService {

    public String createAccount(UserDto userDto);

    List<UserRequestProjection> getAllRequestByUsername(String username);

    UserFundingRequestDetailsDto getRequestByUserAndIdeaName(FetchRequest fetchRequest);

    UserFundingRequestDetailsDto saveFundRequest(UserFundingRequestDetailsDto dto);
}
