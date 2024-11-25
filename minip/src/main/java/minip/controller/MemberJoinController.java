package minip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import minip.command.UserCommand;
import minip.service.memberJoin.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	@Autowired
	MemberJoinService memberJoinService;
	
	@GetMapping("userLogin")
	public String userLogin() {
		return "thymeleaf/memberJoin/userLogin";
	}
	
	@RequestMapping("userAgree")
	public String agree() {
		return "thymeleaf/memberJoin/agree";
	}
	
	@GetMapping("userWrite")
	public String userWrite() {
		return "thymeleaf/memberJoin/userForm";
	}
	
	@PostMapping("userWrite")
	public String userWrite1(@Validated UserCommand userCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/memberJoin/userForm";
		}
		memberJoinService.execute(userCommand);
		return "thymeleaf/memberJoin/welcome";
	}
	
	

}
