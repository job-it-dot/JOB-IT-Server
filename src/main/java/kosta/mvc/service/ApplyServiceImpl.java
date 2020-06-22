package kosta.mvc.service;

import java.util.ArrayList;
import java.util.List;

import kosta.mvc.domain.Apply;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Resume;
import kosta.mvc.domain.Users;
import kosta.mvc.repository.ApplyRepository;
import kosta.mvc.repository.UsersRepository;

public class ApplyServiceImpl implements ApplyService {
	
	private ApplyRepository applyRep;
	private UsersRepository userRep;
	
	//지원하기, 지원상태 : 1 - 지원, 0 - 지원x
	@Override
	public int apply(Long recruitId, Long resumeId) {
		int result = 0;
		
		Recruit recruit = new Recruit();
		recruit.setRecruitId(recruitId);
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		int applyStatus = 1;
		Apply apply = new Apply();
		apply.setRecruit(recruit);
		apply.setResume(resume);
		apply.setApplyStatus(applyStatus);
		
		Apply dbapp = applyRep.save(apply);
		if(dbapp != null) {
			result = 1;//result 1 - 성공
		}
		return result;
	}
	
	//지원취소
	@Override
	public int cancleApply(Long applyId) {
		int result = 0;
		if(applyId != null) {
			applyRep.deleteById(applyId);
			result = 1;
		}
		return result;
	}
	
	//지원한곳 목록보기_채용공고
	@Override
	public List<Recruit> selectApplyCompany(Long userId) {
		Users user = userRep.findById(userId).orElse(null);
		List<Apply> apply = user.getApply();
		List<Recruit> recruitList = new ArrayList<Recruit>();
		for(Apply app : apply) {
			recruitList.add(app.getRecruit());
		}
		
		return recruitList;
	}
	
	//지원한곳 지원상태 조회(서류 심사중, 서류 탈락, 면접 진행 중, 최종 합격) 조회
	@Override
	public int selectApplyStatus(Long applyId) {
		Apply apply = applyRep.findById(applyId).orElse(null);
		int applyStatus = apply.getApplyStatus();
		
		return applyStatus;
	}

	

}
