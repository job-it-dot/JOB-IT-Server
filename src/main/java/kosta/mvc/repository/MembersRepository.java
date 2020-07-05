package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {
	
	@Query("SELECT m FROM Members m WHERE m.memberEmail=?1")
	public Members findByMemberEmail(String memberEmail);
	
}
