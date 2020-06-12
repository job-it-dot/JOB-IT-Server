package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.CompanyImage;

public interface CompanyImageRepository extends JpaRepository<CompanyImage, Long> {

}
