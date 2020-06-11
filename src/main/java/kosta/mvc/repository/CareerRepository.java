package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {

}
