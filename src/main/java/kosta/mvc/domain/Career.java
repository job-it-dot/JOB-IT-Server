package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import kosta.mvc.DTO.CareerDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Career {
	
	public Career(CareerDTO careerDTO){
		this.careerId = careerDTO.getCareerId();
		this.careerCompanyName = careerDTO.getCareerCompanyName();
		this.careerPosition = careerDTO.getCareerPosition();
		this.careerStartAt = careerDTO.getCareerStartAt();
		this.careerEndAt = careerDTO.getCareerEndAt();
		this.careerStatus = careerDTO.getCareerStatus();
		this.resume = new Resume(careerDTO.getResume());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long careerId;
	private String careerCompanyName;
	private String careerPosition;
	private String careerStartAt;
	private String careerEndAt;
	private int careerStatus;
	
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@OneToMany(mappedBy = "career", fetch = FetchType.LAZY)
	private List<Project> projects = new ArrayList<Project>();
}
