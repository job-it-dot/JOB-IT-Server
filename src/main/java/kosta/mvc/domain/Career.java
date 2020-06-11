package kosta.mvc.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Career {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long careerId;
	private Resume resume;
	private String careerCompanyName;
	private String careerPosition;
	private String careerStartDate;
	private String careerEndDate;
	private int careerStatus;
	
	private List<Project> projectList;
}
