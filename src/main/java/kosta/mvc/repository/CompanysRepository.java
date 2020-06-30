package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Companys;

public interface CompanysRepository extends JpaRepository<Companys, Long> {

	@Query("SELECT c.companyId FROM Companys c WHERE c.member.memberId=?1")
	public Long findByMemberId(Long memberId);
	
}
