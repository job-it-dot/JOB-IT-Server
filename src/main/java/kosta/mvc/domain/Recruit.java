package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import kosta.mvc.DTO.RecruitDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
	
	public Recruit(RecruitDTO recruitDTO){
		this.recruitId = recruitDTO.getRecruitId();
		this.position = new Positions(recruitDTO.getPosition());
		this.recruitForm = new RecruitForm(recruitDTO.getRecruitForm());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitId;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private Positions position;
	
	@ManyToOne
	@JoinColumn(name="recruit_form_id")
	private RecruitForm recruitForm;
	
	@OneToMany(mappedBy = "recruit", fetch = FetchType.LAZY)
	private List<Apply> applys = new ArrayList<Apply>();

}
