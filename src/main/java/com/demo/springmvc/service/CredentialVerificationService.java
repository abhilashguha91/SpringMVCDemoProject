package com.demo.springmvc.service;

import org.springframework.stereotype.Service;

@Service
public class CredentialVerificationService {

	public boolean verifyCredentials(String userName, String password) {
		
		if("admin".equals(password)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
