package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u.userId FROM Users u WHERE u.member.memberId=?1")
	public Long findByMemberId(Long memberId);

}
