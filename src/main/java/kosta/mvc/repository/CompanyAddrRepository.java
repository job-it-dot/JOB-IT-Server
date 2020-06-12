package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.CompanyAddr;

public interface CompanyAddrRepository extends JpaRepository<CompanyAddr, Long> {

}
