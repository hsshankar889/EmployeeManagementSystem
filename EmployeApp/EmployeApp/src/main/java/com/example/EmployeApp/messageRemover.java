package com.example.EmployeApp;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class messageRemover {

	public void remove()
	{
		RequestAttributes  requestAttributes=RequestContextHolder.currentRequestAttributes(); 
		ServletRequestAttributes attributes=(ServletRequestAttributes)requestAttributes;
		HttpServletRequest request=attributes.getRequest();
		HttpSession session=request.getSession(true);
		session.removeAttribute("message");
		
	}
}
