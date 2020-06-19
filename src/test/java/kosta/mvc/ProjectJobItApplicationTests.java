package kosta.mvc;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kosta.mvc.domain.Career;
import kosta.mvc.domain.Resume;
import kosta.mvc.repository.CareerRepository;
import kosta.mvc.repository.ResumeRepository;

@SpringBootTest
class ProjectJobItApplicationTests {

	@Autowired
	private ResumeRepository rep;
	
	@Autowired
	private CareerRepository cep;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void insert() {
		List<Career> careerlist = new ArrayList<Career>(); 
		careerlist.add(new Career(null, "회사1", "직급", "시작", "끝", 0,  null, null));
		careerlist.add(new Career(null, "회사2", "직급", "시작", "끝", 0,  null, null));
		
		rep.save(new Resume(null, null, "이력", "000", "내용",  0, null, careerlist, null, null, null, null));
	}
	
	@Test
	public void selectAll() {
		List<Resume> resumelist = rep.findAll();
		
		resumelist.forEach(b->System.out.println(b));
	}
	
	@Test
	public void selectById() {
		
	}

}
