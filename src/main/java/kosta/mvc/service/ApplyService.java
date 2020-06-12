package kosta.mvc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Resume;

public interface ApplyService {
	//지원하기_이력서와 공고의 정보가 들어가야한다. result 성공 - 1, 실패 - 0
	int apply(Apply apply) throws NotFoundException, IOException;
	
	//지원 취소 result 성공 - 1, 실패 - 0
	int cancleApply(int applyId) throws NotFoundException, IOException;
	
	//지원한곳 목록 보기_회사_채용공고
	List<Apply> selectApplyCompany() throws NotFoundException, IOException;
	
	//지원상태 조회(지원완료, 취소) result 성공 - 1, 실패 - 0
	int selectApplyStatus(int applyId) throws NotFoundException, IOException;
	
	//지원한곳 지원상태 조회(서류 심사중, 서류 탈락, 면접 진행 중, 최종 합격) 조회 result 성공 - 1, 실패 - 0
	int selectPassState(int applyId) throws NotFoundException, IOException;
}
