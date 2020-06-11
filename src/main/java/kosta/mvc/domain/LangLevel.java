package kosta.mvc.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LangLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langLevelId;
	private String langLevelName;
}
