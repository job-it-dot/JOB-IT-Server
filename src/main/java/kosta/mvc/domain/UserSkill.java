package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.UserSkillDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSkill {
	
	UserSkill(UserSkillDTO userSkillDTO){
		this.userSkillId = userSkillDTO.getUserSkillId();
		this.skill = new Skills(userSkillDTO.getSkill());
		this.resume = new Resume(userSkillDTO.getResume());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userSkillId;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Skills skill;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
}
