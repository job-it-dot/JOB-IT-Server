package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Recruit;

public interface RecrutiRepository extends JpaRepository<Recruit, Integer> {
	//채용정보 목록조회
	
	//채용정보 상세조회
	
	//관심 기업 등록
	
	//관심 기업 해지
	
	//채용공고 스크랩
	
	//채용공고 스크랩 취소하기
	
	//스크랩 채용공고 목록 조회
	
	//스크랩 채용공고 삭제
	
	//관심기업 등록
	
	//관심 기업 해지
	
	//관심기업 목록 조회
	
	//관심기업 삭제
	
}
