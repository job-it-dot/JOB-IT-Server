package kosta.mvc.repository;

import java.util.List;

import org.springframework.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kosta.mvc.domain.Recruit;
import lombok.RequiredArgsConstructor;

import static kosta.mvc.domain.QRecruit.recruit;

@RequiredArgsConstructor
public class RecruitRepositoryImpl implements RecruitRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;
	
	@Override
	public List<Recruit> findRecruitDynamicQuery(String companyName, Integer career, String addr, Integer edu,
			String companyType, Integer salary, String position) {
		return queryFactory
				.selectFrom(recruit)
				.where(conCompanyName(companyName),
						loeCareer(career), 
						conAddr(addr), 
						loeEdu(edu), 
						eqCompanyType(companyType), 
						goeSalary(salary), 
						eqPosition(position))
				.fetch();
	}
	
	private BooleanExpression conCompanyName(String companyName) {
		if(StringUtils.isEmpty(companyName))
			return null;
		return recruit.recruitForm.company.companyName.contains(companyName);
	}
	
	private BooleanExpression loeCareer(Integer career) {
		if(career == null)
			return null;
		return recruit.recruitForm.recruitCareer.loe(career);
	}
	
	private BooleanExpression conAddr(String addr) {
		if(StringUtils.isEmpty(addr))
			return null;
		return recruit.recruitForm.recruitAddr.companyAddr.companyAddrDetail.contains(addr);
	}
	
	private BooleanExpression loeEdu(Integer edu) {
		if(edu == null)
			return null;
		return recruit.recruitForm.requiredEdu.reqEduGrade.loe(edu);
	}
	
	private BooleanExpression eqCompanyType(String companyType) {
		if(StringUtils.isEmpty(companyType))
			return null;
		return recruit.recruitForm.company.companyType.companyTypeName.eq(companyType);
	}
	
	private BooleanExpression goeSalary(Integer salary) {
		if(salary == null)
			return null;
		return recruit.recruitForm.recruitSalary.goe(salary);
	}
	
	private BooleanExpression eqPosition(String position) {
		if(StringUtils.isEmpty(position))
			return null;
		return recruit.position.positionName.eq(position);
				
	}
	

}
