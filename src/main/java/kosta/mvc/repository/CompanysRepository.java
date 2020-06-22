package kosta.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Recruit;

public interface CompanysRepository extends JpaRepository<Companys, Long> {

	public Companys findByCompanyId(Long companyId);
	
}
