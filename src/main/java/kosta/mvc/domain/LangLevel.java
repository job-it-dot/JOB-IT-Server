package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kosta.mvc.DTO.LangLevelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LangLevel {
	
	LangLevel(LangLevelDTO langLevelDTO){
		this.langLevelId = langLevelDTO.getLangLevelId();
		this.langLevelName = langLevelDTO.getLangLevelName();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langLevelId;
	private String langLevelName;
}
