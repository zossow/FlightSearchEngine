package com.flight.search.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showHome() {

        return "index";
    }


    @GetMapping("/admin")
    public String showAdminHomePage() {

        return "admin-menu";
    }


    @GetMapping("/user")
    public String showUserHomePage() {

        return "user-menu";
    }

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "login";
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}

    @RequestMapping("/authenticated")
    public void authenticated(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {

        String role =  authResult.getAuthorities().toString();

        if(role.contains("ROLE_USER")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/user/menu"));
        }else if(role.contains("ROLE_ADMIN")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/menu"));
        }
    }
	
}









