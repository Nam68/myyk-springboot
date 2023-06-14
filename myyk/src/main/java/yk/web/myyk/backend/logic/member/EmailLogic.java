package yk.web.myyk.backend.logic.member;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.EmailService;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.mail.MailTemplateName;
import yk.web.myyk.util.enumerated.Error;

@Service
public class EmailLogic extends BaseLogic implements EmailService {

	@Override
	@Transactional
	public void sendEmailConfirm(String email) throws SystemException {
		
		int code = getRandomInt(4);
		
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
		
		Optional<TmpCodeEntity> entity = getRepository().getTmpCode().findByTmpCode(tmpCode);
		if (entity.isPresent()) {
			if (entity.get().getRegisterdDate().isAfter(
					LocalDateTime.now().minusMinutes(getConstants().getTmpCodeLImitMinute()))) {
				return entity.get().getEmail();
			} else {
				getRepository().getTmpCode().delete(entity.get());
			}
		}
		return Error.ERROR.getValue();
	}

}
