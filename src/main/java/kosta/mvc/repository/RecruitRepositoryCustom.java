package kosta.mvc.repository;

import java.util.List;

import kosta.mvc.domain.Recruit;

public interface RecruitRepositoryCustom {
	
	List<Recruit> findRecruitDynamicQuery (String companyName, Integer career, String addr, Integer edu, String companyType, Integer salary, String position);

}
