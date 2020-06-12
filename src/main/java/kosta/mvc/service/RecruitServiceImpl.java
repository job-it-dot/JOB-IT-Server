package kosta.mvc.service;

import java.util.List;

import kosta.mvc.domain.Alram;
import kosta.mvc.domain.Follow;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Scrap;
import kosta.mvc.repository.RecruitRepository;

public class RecruitServiceImpl implements RecruitService {
	
	private RecruitRepository recru;
	
	//채용정보 목록 조회
	@Override
	public List<Recruit> selectAllRecruitInfoList() {
		List<E> recru.findAll();
		return null;
	}

	@Override
	public List<Recruit> selectRecruitById(int recruitId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerInterestCompany(Follow follow) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancleInterestCompany(int followId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Follow> selectAllInterestCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteInterestCompany(int followId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int scrapRecruit(Scrap scrap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancleScrapRecruit(int scrapId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Scrap> selectAllScrap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteScrapRecruit(int scrapId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAlram(Alram alram) {
		// TODO Auto-generated method stub
		return 0;
	}

}
