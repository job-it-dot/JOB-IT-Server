package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="user_id")
	private Users user;
	
	private String resumeName;
	private String resumePhone;
	private String resumeContent;
	private int resumeStatus;
	
	@OneToMany(mappedBy = "resume")
	private List<Edu> edus = new ArrayList<Edu>();
	
	@OneToMany(mappedBy = "resume")
	private List<Career> careers = new ArrayList<Career>();
	
	@OneToMany(mappedBy = "resume")
	private List<License> licenses = new ArrayList<License>();
	
	@OneToMany(mappedBy = "resume")
	private List<Lang> langs = new ArrayList<Lang>();
		
	@OneToMany(mappedBy = "resume")
	private List<UserSkill> userSkills = new ArrayList<UserSkill>();
	
	@OneToMany(mappedBy = "resume")
	private List<Link> links = new ArrayList<Link>();
	
	
}
