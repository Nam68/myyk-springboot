package yk.web.myyk.backend.logic.member;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.LoginDTO;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.backend.entity.member.AutoLoginEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.LoginService;
import yk.web.myyk.util.exception.SystemException;

@Service
public class LoginLogic extends BaseLogic implements LoginService {

	@Override
	public LoginInfo find(LoginDTO dto) throws SystemException {
		
		List<MemberEntity> all = getRepository().getMember().findAllByEmail(encrypt(dto.getEmail()));
		if (all.isEmpty() || all.size() > 1) {
			return null;
		}
		
		MemberEntity entity = all.get(0);
		if (!entity.passwordValidate(dto.getPassword())) {
			return null;
		}
		
		return new LoginInfo(entity);
	}

	@Override
	@Transactional
	public String createAutoLoginSession(LoginDTO dto) throws SystemException {
		
		List<MemberEntity> all = getRepository().getMember().findAllByEmail(encrypt(dto.getEmail()));
		if (all.isEmpty() || all.size() > 1) {
			return null;
		}
		AutoLoginEntity auto = new AutoLoginEntity(all.get(0));
		
		getRepository().getAutoLogin().save(auto);
		
		return auto.getSessionId();
	}

}
