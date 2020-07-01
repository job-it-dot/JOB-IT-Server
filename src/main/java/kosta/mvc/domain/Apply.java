package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.ApplyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applyId;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	private int applyStatus;
	
	@ManyToOne
	@JoinColumn(name="recruit_id")
	private Recruit recruit;
}
