package com.demo.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springmvc.service.CredentialVerificationService;

@Controller
public class LoginController {
	
	@Autowired
	CredentialVerificationService cvService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doAdd(HttpServletRequest request, HttpServletResponse response) {
		
		String userName = (String)request.getParameter("userName");
		String password = (String)request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		
		
		if(cvService.verifyCredentials(userName, password)) {
			mv.setViewName("welcomePage.jsp");
			mv.addObject("userName", userName);
		}else {
			mv.setViewName("login.jsp");
			mv.addObject("errorMsg", "Wrong Username or Password");
		}
		
		return mv;
		
		
	}

}
