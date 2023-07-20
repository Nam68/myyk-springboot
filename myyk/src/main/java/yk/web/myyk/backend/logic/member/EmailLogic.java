package yk.web.myyk.backend.logic.member;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.EmailService;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.mail.MailTemplateName;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.errorCode.ErrorCode;

@Service
public class EmailLogic extends BaseLogic implements EmailService {

	@Override
	@Transactional
	public void sendEmailConfirm(String email) throws SystemException {
		
		// 로봇 대책
		if (getRepository().getTmpCode().findAllByEmail(encode(email)).size() > getConstants().getTmpCodeLImitTimes()) {
			throw new SystemException(ErrorCode.CT_101, EmailLogic.class);
		}
		
		// 중복된 코드를 생성하지 않음
		String code = String.valueOf(getRandomInt(6));
		while (getRepository().getTmpCode().findByTmpCode(code).isPresent()) {
			code = String.valueOf(getRandomInt(6));
		}
		
		getMailTemplate().setTo(email)
			.setSubject(getMailTemplate().getTextConfig().signupSubject())
			.setTemplateName(MailTemplateName.SIGNUP_MAIL)
			.setParameter("message", getMailTemplate().getTextConfig().signupText())
			.setParameter("code", getMailTemplate().getTextConfig().signupCode() + code)
			.send();
		
		getRepository().getTmpCode().save(new TmpCodeEntity(code, email));
	}
	
	@Override
	public String checkTmpCode(int tmpCode) throws SystemException {
		String encodedTmpCode = hashing(String.valueOf(tmpCode));
		TmpCodeEntity entity = getRepository().getTmpCode().findByTmpCode(encodedTmpCode).orElse(null);
		if (entity != null) {
			return String.valueOf(tmpCode);
		} else {
			return Error.ERROR.getValue();
		}
	}

}
