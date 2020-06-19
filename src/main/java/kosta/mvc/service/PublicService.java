package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Recruit;

public interface PublicService {
	
	List<Recruit> searchRecruit(String companyName, Integer career, String addr, Integer edu,
			String companyType, Integer salary, String position);

}
