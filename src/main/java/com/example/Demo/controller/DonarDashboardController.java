package com.example.Demo.controller;

import com.example.Demo.Dto.DonarDashboardInfoDTO;
import com.example.Demo.Dto.RecordsDto;
import com.example.Demo.Exception.NotFoundException;
import com.example.Demo.Repository.StudentFundingRequestDetailsRepository;
import com.example.Demo.Service.DonarDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")

public class DonarDashboardController {

    @Autowired
    DonarDashboard donarDashboard;

    @Autowired
    StudentFundingRequestDetailsRepository studentFundingRequestDetailsRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllStudents")
    public ResponseEntity<List<DonarDashboardInfoDTO>> getAllStudentsEligibleForFunding(){
       List<DonarDashboardInfoDTO> result= donarDashboard.getAllELigibleStudents("Uni_verified");
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
}
