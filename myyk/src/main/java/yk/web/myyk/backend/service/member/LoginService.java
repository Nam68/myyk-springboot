package yk.web.myyk.backend.service.member;

import yk.web.myyk.backend.dto.LoginDTO;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.util.exception.SystemException;

public interface LoginService {

	/**
	 * <p>로그인 정보를 찾아낸다.</p>
	 * 
	 * @param dto 로그인 DTO
	 * @return 회원 엔티티
	 * @throws SystemException 시스템 에러
	 */
	public LoginInfo find(LoginDTO dto) throws SystemException;
	
	/**
	 * <p>자동 로그인 정보를 데이터베이스에 등록한다.</p>
	 * 
	 * @param dto 자동 로그인 대상
	 * @return 자동 로그인 세션ID
	 * @throws SystemException 시스템 에러
	 */
	public String createAutoLoginSession(LoginDTO dto) throws SystemException;
	
}
