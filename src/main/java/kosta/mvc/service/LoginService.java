package kosta.mvc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Members;
import kosta.mvc.repository.CompanysRepository;
import kosta.mvc.repository.MembersRepository;
import kosta.mvc.repository.UsersRepository;

@Service
public class LoginService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private CompanysRepository companysRepository;

	@Autowired
	private MembersRepository membersRepository;

	public Map<String, Object> login(Members member) {

		Map<String, Object> map = new HashMap<>();
		
		Members dbMember = membersRepository.findByMemberEmail(member.getMemberEmail());
		
		if(dbMember==null || !dbMember.getMemberPassword().equals(member.getMemberPassword())) {
			map.put("result", "fail");
			return map;
		}
		
		map.put("result", "succes");

		switch (member.getMemberStatus()) {
		case 1:
			map.put("memberType", "user");
			map.put("user", usersRepository.findByMemberId(member.getMemberId()));
			break;
		case 2:
			map.put("memberType", "company");
			map.put("company", companysRepository.findByMemberId(member.getMemberId()));
			break;
		case 3:
			map.put("memberType", "admin");
			break;

		default:
			break;
		}

		return map;
	}

}
