package yk.web.myyk.backend.logic.member;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.EmailService;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.mail.MailTemplateName;
import yk.web.myyk.util.enumerated.Error;

@Service
public class EmailLogic extends BaseLogic implements EmailService {

	@Override
	@Transactional
	public void sendEmailConfirm(String email) throws SystemException {

		String code = hashing(String.valueOf(getRandomInt(4)));
		String encodedEmail = encode(email);
		
		getMailTemplate().setTo(email)
			.setSubject(getMailTemplate().getTextConfig().signupSubject())
			.setTemplateName(MailTemplateName.SIGNUP_MAIL)
			.setParameter("message", getMailTemplate().getTextConfig().signupText())
			.setParameter("code", getMailTemplate().getTextConfig().signupCode() + code)
			.send();
		
		getRepository().getTmpCode().save(new TmpCodeEntity(code, encodedEmail));
		
	}
	
	@Override
	public String checkTmpCode(int tmpCode) throws SystemException {
		String encodedTmpCode = decode(String.valueOf(tmpCode));
		TmpCodeEntity entity = getRepository().getTmpCode().findByTmpCode(encodedTmpCode).orElse(null);
		if (entity != null) {
			if (entity.getRegisterdDate().isAfter(
					LocalDateTime.now().minusMinutes(getConstants().getTmpCodeLImitMinute()))) {
				return entity.getEmail();
			} else {
				getRepository().getTmpCode().delete(entity);
			}
		}
		return Error.ERROR.getValue();
	}

}
