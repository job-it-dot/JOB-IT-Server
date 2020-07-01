package kosta.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kosta.mvc.DTO.FollowDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
	
	Follow(FollowDTO followDTO){
		this.followId = followDTO.getFollowId();
		this.company = new Companys(followDTO.getCompany());
		this.user = new Users(followDTO.getUser());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long followId;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Companys company;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
}
