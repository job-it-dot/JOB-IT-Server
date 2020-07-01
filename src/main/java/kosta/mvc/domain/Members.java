package kosta.mvc.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kosta.mvc.DTO.MembersDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Members {
	
	Members(MembersDTO membersDTO){
		this.memberId = membersDTO.getMemberId();
		this.kakaoId = membersDTO.getKakaoId();
		this.memberEmail = membersDTO.getMemberEmail();
		this.memberPassword = membersDTO.getMemberPassword();
		this.memberStatus = membersDTO.getMemberStatus();
		this.memberJoinDate = membersDTO.getMemberJoinDate();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	private Long kakaoId;
	private String memberEmail;
	private String memberPassword;
	private int memberStatus;
	private Timestamp memberJoinDate;
	
	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<Authority> authorities = new ArrayList<Authority>();
}
