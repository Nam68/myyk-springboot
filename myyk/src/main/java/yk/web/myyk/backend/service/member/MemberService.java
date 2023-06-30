package yk.web.myyk.backend.service.member;

import java.util.Map;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.enumerated.Error;

public interface MemberService {
	
	public Map<String, String> emailValidatio(String email) throws SystemException;
	
	public Map<String, String> createVaildate(MemberDTO dto) throws SystemException;

	public void create(MemberDTO dto) throws SystemException;
	
}
