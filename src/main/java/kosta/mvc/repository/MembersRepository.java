package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {

	public Members findByMemberId(Long memberId);
	
	public List<Members> findByMemberEmail(String memberEmail);
	
	@Query("SELECT * FROM members where member_email =?1 and status=?2")
	public Members findByMemberEmailAndMemberStatus(String memberEmail, int i);
	
}
