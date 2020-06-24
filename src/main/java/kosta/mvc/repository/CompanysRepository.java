package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Companys;

public interface CompanysRepository extends JpaRepository<Companys, Long> {

	public Companys findByCompanyId(Long companyId);

//	@Query("SELECT * FROM members m WHERE m.memberId=?1")
//	public Companys findByMemberId(Long memberId);
	
}
