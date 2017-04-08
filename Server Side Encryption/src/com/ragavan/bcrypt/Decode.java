package com.ragavan.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 

public class Decode {
	     /*
	      * Need to add spring-security-core-4.2.2.RELEASE.jar
	      * Need to add org-apache-commons-logging.jar
	      */
	    public static void main(String[] args) {
	           
	          PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	           
	          String plainTextPassword = "raj";
	           
	          //Encode password before saving plainTextPassword in Database       
	          String hashedPassword = passwordEncoder.encode(plainTextPassword);          
	          System.out.println(hashedPassword);
	           
	           
	          //Validate DB Password with user password
	          String dbPassword = "$2a$10$DEbSgu/YEQ0GH9qREyi9z.ocBorVN8h/zl93oSucssYpR6gca6w2.";
	          boolean isValid = passwordEncoder.matches(plainTextPassword, dbPassword);
	           
	          if (isValid){
	              System.out.println("Password Matched");
	          }
	          else
	          {
	              System.out.println("Password Not Matched");
	          }
	           
	    }
	}

