package yk.web.myyk.backend.service.member;

import java.util.Map;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.enumerated.Error;

public interface MemberService {
	
	/**
	 * <p>이메일이 존재하는지 검증한다.</p>
	 * 
	 * @param email 이메일
	 * @return 에러
	 * @throws SystemException 시스템 에러
	 */
	public Map<String, String> emailValidate(String email) throws SystemException;
	
	/**
	 * <p>신규가입 회원정보를 검증한다.</p>
	 * 
	 * @param dto 회원
	 * @return 에러
	 * @throws SystemException 시스템 에러
	 */
	public Map<String, String> createVaildate(MemberDTO dto) throws SystemException;

	/**
	 * <p>회원을 생성한다.</p>
	 * 
	 * @param dto 회원
	 * @throws SystemException 시스템 에러
	 */
	public void create(MemberDTO dto) throws SystemException;
	
}
