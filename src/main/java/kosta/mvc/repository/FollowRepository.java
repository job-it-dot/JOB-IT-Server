package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

}
