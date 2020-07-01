package kosta.mvc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import kosta.mvc.DTO.LangDTO;
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
	
	Lang(LangDTO langDTO){
		this.langId = langDTO.getLangId();
		this.langClass = new LangClass(langDTO.getLangClass());
		this.langLevel = new LangLevel(langDTO.getLangLevel());
		this.resume = new Resume(langDTO.getResume());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long langId;
	
	@ManyToOne
	@JoinColumn(name="lang_class_id")
	private LangClass langClass;
	
	@ManyToOne
	@JoinColumn(name="lang_level_id")
	private LangLevel langLevel;
	
	@ManyToOne
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@OneToMany(mappedBy = "lang", fetch = FetchType.LAZY)
	private List<LangLicense> langLicenses = new ArrayList<LangLicense>();
	
}
