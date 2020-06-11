package kosta.mvc.domain;

import java.util.List;

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
public class Lang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langId;
	private Resume resume;
	private LangClass langClass;
	private LangLevel langLevel;
	
	private List<LangLicense> langLicenseList;
}
