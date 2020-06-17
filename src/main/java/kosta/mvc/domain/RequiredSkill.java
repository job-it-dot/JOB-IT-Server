package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequiredSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reqSkillsId;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Skills skill;
	
	@ManyToOne
	@JoinColumn(name="recruit_id")
	private Recruit recruit;
}
