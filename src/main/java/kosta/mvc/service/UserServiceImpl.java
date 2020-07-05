package kosta.mvc.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.Users;
import kosta.mvc.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users selectUserByMemberId(Long memberId) throws IOException, NotFoundException {
		return usersRepository.findByMemberId(memberId); 
	}

	@Override
	public Users selectUserById(Long userId) throws IOException {
		return usersRepository.findById(userId).orElse(null);
	}

}
