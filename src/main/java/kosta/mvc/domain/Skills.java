package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kosta.mvc.DTO.SkillsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skills {
	
	Skills(SkillsDTO skillsDTO){
		this.skillId = skillsDTO.getSkillId();
		this.skillName = skillsDTO.getSkillName();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillId;
	private String skillName;
}
