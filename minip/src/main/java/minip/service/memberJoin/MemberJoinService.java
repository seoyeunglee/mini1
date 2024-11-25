package minip.service.memberJoin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import minip.command.UserCommand;
import minip.domain.MemberDTO;
import minip.repository.UserRepository;

@Service
public class MemberJoinService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(UserCommand userCommand) {
		MemberDTO dto = new MemberDTO();
		BeanUtils.copyProperties(userCommand, dto);
		
		if(userCommand.getMemberPhone2() != null) {
			dto.setMemberPhone2(userCommand.getMemberPhone2().trim());
		}
		String encodePw = passwordEncoder.encode(userCommand.getMemberPw());
		dto.setMemberPw(encodePw);
		
		dto.setMemberPost(userCommand.getMemberPost());
		userRepository.userInsert(dto);
		}
	}


