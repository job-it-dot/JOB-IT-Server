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
public class ResumeRead {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resumeReadId;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Companys company;
	
	private boolean isNew;

}
