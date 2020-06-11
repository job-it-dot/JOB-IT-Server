package kosta.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resumeId;
	
	@ManyToOne
	private Users user;
	
	private String resumeName;
	private String resumePhone;
	private String resumeContent;
	private int resumeStatus;
	
	@OneToMany
	private List<Edu> eduList;
	
	@OneToMany
	private List<License> licenseList;
	
	@OneToMany
	private List<Career> careerList;
	
	@OneToMany
	private List<Lang> langList;
	
	@OneToMany
	private List<Link> linkList;
	
	@OneToMany
	private List<UserSkill> userSkillList;
}
