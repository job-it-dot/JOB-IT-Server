package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langLicenseId;
	private String langLicenseName;
	private String langLicenseDate;
	private String langLicenseLevel;
}
