package minip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String userWrite(Model model) {
		UserCommand userCommand = new UserCommand();
		model.addAttribute("userCommand", userCommand);
		return "thymeleaf/memberJoin/userForm";
	}
	
	@PostMapping("userWrite")
	public String userWrite1(@Validated UserCommand userCommand, BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/memberJoin/userForm";
		}
		if(!userCommand.isMemberPwEqualMemberPwCon()) {
			result.rejectValue("memberPwCon", "memberCommand.memberPwCon", "비밀번호가 일치하지 않습니다.");
			return "thymeleaf/memberJoin/userForm";
		}
		memberJoinService.execute(userCommand);
		return "thymeleaf/memberJoin/welcome";
	}
	
	

}
