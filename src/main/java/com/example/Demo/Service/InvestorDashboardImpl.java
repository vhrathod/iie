package com.example.Demo.Service;

import com.example.Demo.Dto.InvestorDashboardInfoDTO;
import com.example.Demo.Entity.UserEntity;
import com.example.Demo.Entity.UserFundingRequestDetails;
import com.example.Demo.Exception.ProcessingException;
import com.example.Demo.Repository.UserFundingRequestDetailsRepository;
import com.example.Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestorDashboardImpl implements InvestorDashboard {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserFundingRequestDetailsRepository studentFundingRequestDetailsRepository;

    @Override
    public List<InvestorDashboardInfoDTO> getAllELigibleStudents(String status) {

        List<UserFundingRequestDetails> studentFundingRequestDetails=studentFundingRequestDetailsRepository.findAllByStatus(status);

        List<String> emaiIds=studentFundingRequestDetails.stream().map(UserFundingRequestDetails::getUsername).collect(Collectors.toList());

        List<UserEntity> userEntities=userRepository.findAllByUserName(emaiIds);

      List<InvestorDashboardInfoDTO> list=new ArrayList<>();

       for(int i=0;i<userEntities.size();i++){
            InvestorDashboardInfoDTO donarDashboardInfoDTO=new InvestorDashboardInfoDTO();
            donarDashboardInfoDTO.setFundingAmount(studentFundingRequestDetails.get(i).getFundingAmtRequired());
            donarDashboardInfoDTO.setGpa(studentFundingRequestDetails.get(i).getGpaOfUser());
            donarDashboardInfoDTO.setReasonForFunding(studentFundingRequestDetails.get(i).getFundingReason());
            donarDashboardInfoDTO.setUniversityName("Abhishek Adoni");
           list.add(donarDashboardInfoDTO);
        }
       return list;
    }

    @Override
    public void updateStudentStatus(List<String> emailId) throws ProcessingException {
        try {
            //studentFundingRequestDetailsRepository.updateStatusToApproved("APPROVED", emailId);
        }catch(Exception e){
            throw new ProcessingException("Failed to update Approved status");
        }
    }

}
