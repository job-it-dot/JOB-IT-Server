package kosta.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kosta.mvc.domain.Apply;

public interface ApplyRepository extends JpaRepository<Apply, Long> {


	public Apply findByApplyId(Long applyId);

}
