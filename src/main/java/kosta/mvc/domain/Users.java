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

import kosta.mvc.DTO.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users{
	
	public Users(UsersDTO usersDTO){
		this.userId = usersDTO.getUserId();
		this.userName = usersDTO.getUserName();
		this.userPhone = usersDTO.getUserPhone();
		this.member = new Members(usersDTO.getMember());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Members member;
	
	private String userName;
	private String userPhone;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Resume> resumes = new ArrayList<Resume>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Alram> alrams = new ArrayList<Alram>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Follow> follows = new ArrayList<Follow>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<ResumeRead> resumeReads = new ArrayList<ResumeRead>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Scrap> scraps = new ArrayList<Scrap>();
	
	@OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
	private List<Apply> apply = new ArrayList<Apply>();
	
}
