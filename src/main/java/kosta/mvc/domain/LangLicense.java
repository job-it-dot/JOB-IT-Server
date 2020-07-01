package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.LangLicenseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LangLicense {
	
	LangLicense(LangLicenseDTO langLicenseDTO){
		this.langLicenseId = langLicenseDTO.getLangLicenseId();
		this.langLicenseName = langLicenseDTO.getLangLicenseName();
		this.langLicenseAt = langLicenseDTO.getLangLicenseAt();
		this.langLicenseLevel = langLicenseDTO.getLangLicenseLevel();
		this.lang = new Lang(langLicenseDTO.getLang());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langLicenseId;
	private String langLicenseName;
	private String langLicenseAt;
	private String langLicenseLevel;
	
	@ManyToOne
	@JoinColumn(name="lang_id")
	private Lang lang;
}
