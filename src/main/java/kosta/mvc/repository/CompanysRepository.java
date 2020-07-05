package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Users;

public interface CompanysRepository extends JpaRepository<Companys, Long> {

	@Query("SELECT c FROM Companys c WHERE c.member.memberId=?1")
	public Companys findByMemberId(Long memberId);
	
}
