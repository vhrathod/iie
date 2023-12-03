package com.example.Demo.Service;

import com.example.Demo.Dto.UserFundingRequestDetailsDto;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Exception.NotFoundException;

public interface UserFundRequest {

    public UserEntity validateRequestAndSendUniName(UserFundingRequestDetailsDto studentFundingRequestDetailsDto) throws NotFoundException;
}
