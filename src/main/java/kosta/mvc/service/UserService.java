package kosta.mvc.service;

import java.io.IOException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import kosta.mvc.domain.Users;

public interface UserService {
	
	/**
	 * 로그인 시 저장된 Members 객체 정보로 userId 찾아오기
	 */
	Long getUserId(Long memberId) throws IOException, NotFoundException;
	
	/**
	 * 회원 정보 조회
	 */
	Users selectUserById(Long userId) throws IOException;
	
}
