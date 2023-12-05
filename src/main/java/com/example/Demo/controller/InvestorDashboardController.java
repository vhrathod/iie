package com.example.Demo.controller;

import com.example.Demo.Dto.InvestorDashboardInfoDTO;
import com.example.Demo.Dto.InvestorToApprove;
import com.example.Demo.Dto.RecordsDto;
import com.example.Demo.Exception.NotFoundException;
import com.example.Demo.Repository.UserFundingRequestDetailsRepository;
import com.example.Demo.Service.InvestorDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")

public class InvestorDashboardController {

    @Autowired
    InvestorDashboard donarDashboard;

    @Autowired
    UserFundingRequestDetailsRepository studentFundingRequestDetailsRepository;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<InvestorDashboardInfoDTO>> getAllStudentsEligibleForFunding(){
       List<InvestorDashboardInfoDTO> result= donarDashboard.getAllELigibleStudents("Uni_verified");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/approved")
    public ResponseEntity<String> updateAllStudentsStatusToApproved(@RequestBody RecordsDto recordsDto) throws NotFoundException {

        try {
            donarDashboard.updateStudentStatus(recordsDto.getEmails());
        }catch (Exception e){
            throw  new NotFoundException("DB update failed");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getAllInvestorToApprove")
    public ResponseEntity<List<InvestorToApprove>> getAllInvestorToApprove(){
        List<InvestorToApprove> result= donarDashboard.getAllInvestorToApprove();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/approveInvestor")
    public ResponseEntity<String> approveInvestor(@RequestParam("username") String username){
        String result= donarDashboard.approveInvestor(username);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
