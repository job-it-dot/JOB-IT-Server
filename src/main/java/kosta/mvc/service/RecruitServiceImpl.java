package kosta.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Follow;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Scrap;
import kosta.mvc.domain.Users;
import kosta.mvc.repository.CompanysRepository;
import kosta.mvc.repository.FollowRepository;
import kosta.mvc.repository.RecruitRepository;
import kosta.mvc.repository.ScrapRepository;
import kosta.mvc.repository.UsersRepository;

@Service
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
	private RecruitRepository recruitRep;
	@Autowired
	private FollowRepository followRep;
	@Autowired
	private ScrapRepository scrapRep;
	@Autowired
	private CompanysRepository companyRep;
	@Autowired
	private UsersRepository userRep;
	
	//채용정보 목록조회
	@Override
	public List<Recruit> selectAllRecruitInfoList() {
		List<Recruit> list = recruitRep.findAll();
		return list;
	}
	
	//채용정보 상세보기
	@Override
	public Recruit selectRecruitById(Long recruitId) throws NotFoundException{
		Recruit dbRecruit = recruitRep.findById(recruitId).orElse(null);
		if(dbRecruit == null) {
			throw new NotFoundException("해당 공고의 정보가 존재하지 않습니다.");
		}
		
		return dbRecruit;
	}
	
	//관심 기업 등록하기
	@Override
	public int registerInterestCompany(Long companyId, Long userId) {
		int result = 1;
		Companys company = new Companys();
		company.setCompanyId(companyId);
		Users user = new Users();
		user.setUserId(userId);
		Follow follow = new Follow();
		follow.setCompany(company);
		follow.setUser(user);
		
		Follow dbfollow = followRep.save(follow);
		if(dbfollow == null) {
			result = 0;
		}
		
		
		return result;
	}

	@Override
	public int cancleInterestCompany(Long followId) {
		followRep.deleteById(followId);
		return 1;
	}
	
	//관심기업 조회
	@Override
	public List<Companys> selectAllInterestCompany(Long userId) {
		Users user = userRep.findById(userId).orElse(null);
		List<Follow> followlist = user.getFollows();
		List<Companys> companyList = new ArrayList<Companys>();	
		for(Follow f : followlist) {
			companyList.add(f.getCompany());
		}
		
		return companyList;
	}

	@Override
	public int deleteInterestCompany(Long followId) {
		followRep.deleteById(followId);
		return 1;
	}
	
	//1 - 성공, 0 - 실패
	@Override
	public int scrapRecruit(Long recruitId, Long userId) {
		int result = 1;
		Recruit recruit = new Recruit();
		recruit.setRecruitId(recruitId);
		Users user = new Users();
		user.setUserId(userId);
		Scrap scrap = new Scrap();
		scrap.setRecruit(recruit);
		scrap.setUser(user);
		Scrap dbScrap = scrapRep.save(scrap);
		if(dbScrap == null) {
			result = 0;
		}
		
		return result;
	}

	@Override
	public int cancleScrapRecruit(Long scrapId) {
		scrapRep.deleteById(scrapId);
		return 1;
	}
	
	//스크랩 공고 조회하기
	@Override
	public List<Recruit> selectAllScrap(Long userId) throws NotFoundException {
		Users user = userRep.findById(userId).orElse(null);
		if(user == null) {
			throw new NotFoundException("해당 사용자를 찾지 못했습니다.");
		}
		List<Scrap> scrapList = user.getScraps();
		List<Recruit> recruitList = new ArrayList<Recruit>();
		for(Scrap s : scrapList) {
			recruitList.add(s.getRecruit());
		}
		return recruitList;
	}

	@Override
	public int deleteScrapRecruit(Long scrapId) {
		scrapRep.deleteById(scrapId);
		return 1;
	}

	//채용 공고가 등록이 되거나 관심 기업이 등록 될때
	@Override
	public int insertAlram(Long recruitId, Long userId) {
		
		return 0;
	}

}
