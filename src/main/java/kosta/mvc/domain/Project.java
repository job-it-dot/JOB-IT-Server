package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	Project(ProjectDTO projectDTO){
		this.projectId = projectDTO.getProjectId();
		this.projectName = projectDTO.getProjectName();
		this.projectStartAt = projectDTO.getProjectStartAt();
		this.projectEndAt = projectDTO.getProjectEndAt();
		this.projectContent = projectDTO.getProjectContent();
		this.career = new Career(projectDTO.getCareer());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	private String projectName;
	private String projectStartAt;
	private String projectEndAt;
	private String projectContent;
	
	@ManyToOne
	@JoinColumn(name="career_id")
	private Career career;
}
