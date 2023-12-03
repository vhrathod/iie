package com.example.Demo.Service;

import com.example.Demo.Dto.InvestorDashboardInfoDTO;
import com.example.Demo.Exception.ProcessingException;

import java.util.List;

public interface InvestorDashboard {

    public List<InvestorDashboardInfoDTO> getAllELigibleStudents(String status);

    public void updateStudentStatus(List<String> emailId) throws ProcessingException;
}
