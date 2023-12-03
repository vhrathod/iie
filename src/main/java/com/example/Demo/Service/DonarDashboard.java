package com.example.Demo.Service;

import com.example.Demo.Dto.DonarDashboardInfoDTO;
import com.example.Demo.Exception.ProcessingException;

import java.util.List;

public interface DonarDashboard {

    public List<DonarDashboardInfoDTO> getAllELigibleStudents(String status);

    public void updateStudentStatus(List<String> emailId) throws ProcessingException;
}
