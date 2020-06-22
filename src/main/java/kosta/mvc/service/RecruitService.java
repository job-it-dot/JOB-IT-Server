package kosta.mvc.service;

import java.util.List;

import javassist.NotFoundException;
import kosta.mvc.domain.Alram;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Follow;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Scrap;
import kosta.mvc.domain.Users;

public interface RecruitService {
	
		//채용정보 목록조회
		List<Recruit> selectAllRecruitInfoList();
	
		//채용정보 상세조회
		Recruit selectRecruitById(Long recruitId) throws NotFoundException;
		
		//관심 기업 등록
		int registerInterestCompany(Long companyId, Long userId);
		
		//관심 기업 해지
		int cancleInterestCompany(Long followId);
		
		//관심기업 목록 조회
		List<Companys> selectAllInterestCompany(Long userId);
				
		//관심기업 삭제
		int deleteInterestCompany(Long followId);
		
		//채용공고 스크랩(등록)
		int scrapRecruit(Long recruitId, Long userId);
		
		//채용공고 스크랩 취소하기
		int cancleScrapRecruit(Long scrapId);
		
		//스크랩 채용공고 목록 조회
		List<Recruit> selectAllScrap(Long userId) throws NotFoundException;
		
		//스크랩 채용공고 삭제
		int deleteScrapRecruit(Long scrapId);
		
		//알림 등록.
		int insertAlram(Long recruitId, Long userId);
		
		
}
