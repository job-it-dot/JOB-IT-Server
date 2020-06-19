package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Recruit;
import kosta.mvc.repository.RecruitRepository;

@Service
public class PublicServiceImpl implements PublicService {
	
	@Autowired
	private RecruitRepository recruitRepo;

	@Override
	public List<Recruit> searchRecruit(String companyName, Integer career, String addr, Integer edu, String companyType,
			Integer salary, String position) {
		
		return recruitRepo.findRecruitDynamicQuery(companyName, career, addr, edu, companyType, salary, position);
	}

}
