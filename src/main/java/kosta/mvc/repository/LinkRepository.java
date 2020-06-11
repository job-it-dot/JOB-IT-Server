package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
