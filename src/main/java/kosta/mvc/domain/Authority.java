package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.AuthorityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
	
	Authority(AuthorityDTO authorityDTO){
		this.authorityId = authorityDTO.getAuthorityId();
		this.authorityName = authorityDTO.getAuthorityName();
		this.member = new Members(authorityDTO.getMember());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorityId;

	@ManyToOne
	@JoinColumn(name="member_id")
	private Members member;
	
	private String authorityName;

}
