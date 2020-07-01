package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.ScrapDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Scrap {
	
	Scrap(ScrapDTO scrapDTO){
		this.scrapId = scrapDTO.getScrapId();
		this.recruit = new Recruit(scrapDTO.getRecruit());
		this.user = new Users(scrapDTO.getUser());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scrapId;
	
	@ManyToOne
	@JoinColumn(name="recruit_id")
	private Recruit recruit;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	
}
