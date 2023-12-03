package com.example.Demo.Service;

import com.example.Demo.Dto.StudentFundingRequestDetailsDto;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Exception.NotFoundException;

public interface StudentFundRequest {

    public UserEntity validateRequestAndSendUniName(StudentFundingRequestDetailsDto studentFundingRequestDetailsDto) throws NotFoundException;
}
