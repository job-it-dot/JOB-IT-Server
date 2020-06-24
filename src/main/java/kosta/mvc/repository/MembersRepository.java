package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {

	public Members findByMemberId(Long memberId);

	public List<Members> findByMemberEmail(String memberEmail);
}
