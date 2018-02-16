package com.gorankadir.se.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@Autowired
	ApplicationUserRepository userRepository;
	
	 @RequestMapping("/")
	    public String welcome(Model model) {
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			ApplicationUser user = userRepository.findByUsername(username);
			model.addAttribute("info", user);
	        return "index";
	    }
	 
//	 @RequestMapping("/login")
//	 public String userLogin(){
//		 return "login";
//	 }

}
