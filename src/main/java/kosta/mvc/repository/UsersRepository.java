package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
