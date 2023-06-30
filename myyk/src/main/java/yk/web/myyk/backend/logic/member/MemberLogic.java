package yk.web.myyk.backend.logic.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.MemberService;
import yk.web.myyk.util.exception.SystemException;

@Service
public class MemberLogic extends BaseLogic implements MemberService {
	
	@Override
	public Map<String, String> emailValidate(String email) throws SystemException {
		Map<String, String> errors = new HashMap<>();
		if (getRepository().getMember().findAllByEmail(encode(email)).size() > 0) {
			errors.put("email", EMAIL_DUPLICATION_ERROR);
		}
		return errors;
	}
	
	@Override
	public Map<String, String> createVaildate(MemberDTO dto) throws SystemException {
		Map<String, String> errors = new HashMap<>();
		if (getRepository().getMember().findAllByNickname(dto.getNickname()).size() > 0) {
			errors.put("nickname", NICKNAME_DUPLICATION_ERROR);
		}
		return errors;
	}

	@Override
	@Transactional
	public void create(MemberDTO dto) throws SystemException {
		MemberEntity entity = new MemberEntity(
				dto, 
				getConstants().getMemberPasswordSaltLength(),
				getConstants().getMemberPasswordHashingTimes());
		getRepository().getMember().save(entity);
	}
}
