package kosta.mvc.domain;

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
public class Career {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long careerId;
	private String careerCompanyName;
	private String careerPosition;
	private String careerStartYymm;
	private String careerEndYymm;
	private int careerStatus;
	
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
}
