package kosta.mvc.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.domain.Companys;
import kosta.mvc.domain.Members;
import kosta.mvc.domain.Perchase;
import kosta.mvc.domain.Users;
import kosta.mvc.repository.CompanysRepository;
import kosta.mvc.repository.MembersRepository;
import kosta.mvc.repository.PerchaseRepository;
import kosta.mvc.repository.UsersRepository;

@Service
public class AdminserviceImpl implements AdminService {
	
	@Autowired
	private UsersRepository userRepository;
		
	@Autowired
	private CompanysRepository companyRepository;
	
	@Autowired
	private PerchaseRepository perchaseRepository;
	
	@Override
	public List<Users> selectUser() throws IOException {
		List<Users> list = userRepository.findAll();
		return list;
	}
	
	@Override
	public Users selectById(long userId) throws IOException {
		Users user = userRepository.findById(userId).orElse(null);
		return user;
	}
	
	@Override
	public List<Companys> selectCompany() throws IOException {
		List<Companys> list = companyRepository.findAll();
		return list;
	}
	
	@Override
	public Companys selelctCompanyId(long CompanyId) throws IOException {
		Companys company = companyRepository.findById(CompanyId).orElse(null);
		return company;
	}

	/**
	 *  status 값이 2로 바뀌면 탈퇴됨.
	 *  @return 1을 리턴하면 탈퇴처리성공
	 */
	@Override
	public int companysWithdrawal(long companyId) throws NotFoundException, IOException {
		Companys company = companyRepository.findById(companyId).orElse(null);
		if(company == null) {
			throw new NotFoundException();
		}		
		company.getMember().setMemberStatus(2);
		
		return 1;
	}

	@Override
	public int memberWithdrawal(long memberId) throws NotFoundException, IOException {
		Users user = userRepository.findById(memberId).orElse(null);
		if(user == null) {
			throw new NotFoundException();
		}
		user.getMember().setMemberStatus(2);
		
		return 1;
	}
	
	/**
	 * status 값이 4이면 가입승인
	 */
	@Override
	public int companyApproval(long companyId) throws IOException {
		Companys company = companyRepository.findById(companyId).orElse(null);
		company.getMember().setMemberStatus(4);
		return 1;
	}

	@Override
	public List<Perchase> salesSelect() throws IOException {
		List<Perchase> list = perchaseRepository.findAll();
		return list;
	}
	
	/**
	 * 보류
	 */
	@Override
	@Transactional
	public int Refund(long perchaseId) throws RuntimeException, IOException {
		//보류
		Perchase perchase = perchaseRepository.findById(perchaseId).orElse(null);		
		perchase.getProduct().setProductStatus(3);
		int price = perchase.getPerchasePrice();
		Date date = perchase.getPerchaseTime();
		
		
		return 1;
	}

}
