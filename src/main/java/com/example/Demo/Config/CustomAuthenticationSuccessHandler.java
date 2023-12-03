package com.example.Demo.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        if(authentication.getAuthorities().stream().anyMatch(auth->"ROLE_STUDENT".equals(auth.getAuthority()))){

            redirectStrategy.sendRedirect(request,response,"http://localhost:3000/student/studentRequestFund/");
        }

        if(authentication.getAuthorities().stream().anyMatch(auth->"ROLE_DONOR".equals(auth.getAuthority()))){
            redirectStrategy.sendRedirect(request,response,"http://localhost:3000/donor/");
        }

    }
}

