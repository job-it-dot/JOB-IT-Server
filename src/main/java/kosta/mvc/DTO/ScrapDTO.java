package kosta.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapDTO {
	
	private Long scrapId;
	
	private RecruitDTO recruit;
	
	private UsersDTO user;
	
}
