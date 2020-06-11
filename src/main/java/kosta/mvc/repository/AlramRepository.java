package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Alram;

public interface AlramRepository extends JpaRepository<Alram, Long> {

}
