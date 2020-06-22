package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Resume;

public interface ApplyService {
	//지원하기_이력서와 공고의 정보가 들어가야한다.
	int apply(Long recruitId, Long resumeId);
	
	//지원 취소
	int cancleApply(Long applyId);
	
	//지원한곳 목록 보기_회사_채용공고
	List<Recruit> selectApplyCompany(Long userId);
	
	//지원상태 조회(지원완료, 취소)
	int selectApplyStatus(Long applyId);
	
	
}
