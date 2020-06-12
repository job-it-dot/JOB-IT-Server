package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Alram;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Follow;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Scrap;

public interface RecruitService {
		//채용정보 목록조회
		List<Recruit> selectAllRecruitInfoList();
	
		//채용정보 상세조회
		List<Recruit> selectRecruitById(int recruitId);
		
		//관심 기업 등록 result 성공 - 1, 실패 - 0
		int registerInterestCompany(Follow follow);
		
		//관심 기업 해지 result 성공 - 1, 실패 - 0
		int cancleInterestCompany(int followId);
		
		//관심기업 목록 조회 
		List<Follow> selectAllInterestCompany();
				
		//관심기업 삭제 result 성공 - 1, 실패 - 0
		int deleteInterestCompany(int followId);
		
		//채용공고 스크랩(등록) result 성공 - 1, 실패 - 0
		int scrapRecruit(Scrap scrap);
		
		//채용공고 스크랩 취소하기 result 성공 - 1, 실패 - 0
		int cancleScrapRecruit(int scrapId);
		
		//스크랩 채용공고 목록 조회
		List<Scrap> selectAllScrap();
		
		//스크랩 채용공고 삭제 result 성공 - 1, 실패 - 0
		int deleteScrapRecruit(int scrapId);
		
		//알림 등록. result 성공 - 1, 실패 - 0
		int insertAlram(Alram alram);
		
		
}
