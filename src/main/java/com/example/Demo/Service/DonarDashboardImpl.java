package com.example.Demo.Service;

import com.example.Demo.Dto.DonarDashboardInfoDTO;
import com.example.Demo.Entity.UserFundingRequestDetails;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Exception.ProcessingException;
import com.example.Demo.Repository.StudentFundingRequestDetailsRepository;
import com.example.Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonarDashboardImpl implements DonarDashboard{

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentFundingRequestDetailsRepository studentFundingRequestDetailsRepository;

    @Override
    public List<DonarDashboardInfoDTO> getAllELigibleStudents(String status) {

        List<UserFundingRequestDetails> studentFundingRequestDetails=studentFundingRequestDetailsRepository.findAllByStatus(status);

        List<String> emaiIds=studentFundingRequestDetails.stream().map(UserFundingRequestDetails::getUsername).collect(Collectors.toList());

        List<UserEntity> userEntities=userRepository.findAllByUserName(emaiIds);

      List<DonarDashboardInfoDTO> list=new ArrayList<>();

       for(int i=0;i<userEntities.size();i++){
            DonarDashboardInfoDTO donarDashboardInfoDTO=new DonarDashboardInfoDTO();
            donarDashboardInfoDTO.setFundingAmount(studentFundingRequestDetails.get(i).getFundingAmount());
            donarDashboardInfoDTO.setGpa(studentFundingRequestDetails.get(i).getGpa());
            donarDashboardInfoDTO.setReasonForFunding(studentFundingRequestDetails.get(i).getFundingReason());
            donarDashboardInfoDTO.setUniversityName("Abhishek Adoni");
           list.add(donarDashboardInfoDTO);
        }
       return list;
    }

    @Override
    public void updateStudentStatus(List<String> emailId) throws ProcessingException {
        try {
            studentFundingRequestDetailsRepository.updateStausToApproved("APPROVED", emailId);
        }catch(Exception e){
            throw new ProcessingException("Failed to update Approved status");
        }
    }

}
