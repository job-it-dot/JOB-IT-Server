package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.LinkDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
	
	Link(LinkDTO linkDTO){
		this.linkId = linkDTO.getLinkId();
		this.linkContent = linkDTO.getLinkContent();
		this.resume = new Resume(linkDTO.getResume());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long linkId;
	private String linkContent;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
}
