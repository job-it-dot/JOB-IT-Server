package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Members;

public interface MembersRepository extends JpaRepository<Members, Long> {

	public Members findByMemberId(Long memberId);
}
