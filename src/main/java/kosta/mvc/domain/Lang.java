package kosta.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langId;
	
	@ManyToOne
	private LangClass langClass;
	
	@ManyToOne
	private LangLevel langLevel;
	
	@OneToMany
	private List<LangLicense> langLicenseList;
}
