package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kosta.mvc.domain.Recruit;

import static kosta.mvc.domain.QRecruit.recruit;

@Repository
public class RecruitRepositorySupport extends QuerydslRepositorySupport {
	
	private final JPAQueryFactory queryFactory;
	

	public RecruitRepositorySupport(JPAQueryFactory queryFactory) {
        super(Recruit.class);
        this.queryFactory = queryFactory;
    }

    public List<Recruit> findByName(String companyName) {
        return queryFactory
                .selectFrom(recruit)
                .where(recruit.company.companyName.eq(companyName))
                .fetch();
    }

}
