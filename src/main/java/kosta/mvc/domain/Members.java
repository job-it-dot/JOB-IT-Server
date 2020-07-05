package kosta.mvc.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

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
	
	public Members(MembersDTO membersDTO){
		this.memberEmail = membersDTO.getMemberEmail();
		this.memberPassword = membersDTO.getMemberPassword();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@Column(unique=true)
	private String memberEmail;
	private String memberPassword;
	private int memberStatus;
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp memberJoinDate;
		
}
