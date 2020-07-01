package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.ResumeReadDTO;
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
	
	ResumeRead(ResumeReadDTO resumeReadDTO){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resumeReadId;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Companys company;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users user;
	
	private boolean isNew;

}
