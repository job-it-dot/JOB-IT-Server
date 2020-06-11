package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Edu;

public interface EduRepository extends JpaRepository<Edu, Long> {

}
