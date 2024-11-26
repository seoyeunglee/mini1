package minip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import minip.service.IdCheckService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	IdCheckService idCheckService;
	
	@PostMapping("userIdCheck")
	public @ResponseBody Integer userIdCheck(String userId) {
		return idCheckService.execute(userId);
	}
	
	
}
