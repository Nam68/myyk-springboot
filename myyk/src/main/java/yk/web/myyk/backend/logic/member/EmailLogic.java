package yk.web.myyk.backend.logic.member;

import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.EmailService;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.mail.MailTemplateName;
import yk.web.myyk.util.mail.holder.TmpCodeMailHolder;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;

@Service
public class EmailLogic extends BaseLogic implements EmailService {

    @Override
    public void sendTmpMemberCode(EmailForm emailForm, String tmpCode) throws SystemException, AppException {

        String email = combineEmail(emailForm);

        // 로봇 대책
        if (getRepository().getTmpCode().findByEmail(encrypt(email)).size() > Constant.getTmpCodeLimitTimes()) {
            throw new SystemException(ErrorCode.CT_101, EmailLogic.class);
        }

        TmpCodeMailHolder holder = new TmpCodeMailHolder(getMailText().signupText(), getMailText().signupCode());
        String content = getFreeMarkerFactory().setTemplateName(MailTemplateName.SIGNUP_MAIL).setParameter(holder).get();

        getMailTemplate()
            .setTo(email)
            .setSubject(getMailTemplate().getTextConfig().signupSubject())
            .setContent(content)
            .send();
    }

//	@Override
//	@Transactional
//	public void sendEmailConfirm(String email) throws SystemException {
//		
//		// 로봇 대책
//		if (getRepository().getTmpCode().findAllByEmail(encode(email)).size() > getConstants().getTmpCodeLImitTimes()) {
//			throw new SystemException(ErrorCode.CT_101, EmailLogic.class);
//		}
//		
//		// 중복된 코드를 생성하지 않음
//		String code = String.valueOf(getRandomInt(6));
//		while (getRepository().getTmpCode().findByTmpCode(code).isPresent()) {
//			code = String.valueOf(getRandomInt(6));
//		}
//		
//		getMailTemplate().setTo(email)
//			.setSubject(getMailTemplate().getTextConfig().signupSubject())
//			.setTemplateName(MailTemplateName.SIGNUP_MAIL)
//			.setParameter("message", getMailTemplate().getTextConfig().signupText())
//			.setParameter("code", getMailTemplate().getTextConfig().signupCode() + code)
//			.send();
//		
//		getRepository().getTmpCode().save(new TmpCodeEntity(code, email));
//	}
//	
//	@Override
//	public String checkTmpCode(int tmpCode) throws SystemException {
//		String encodedTmpCode = hashing(String.valueOf(tmpCode));
//		TmpCodeEntity entity = getRepository().getTmpCode().findByTmpCode(encodedTmpCode).orElse(null);
//		if (entity != null) {
//			return String.valueOf(tmpCode);
//		} else {
//			return Error.ERROR.getValue();
//		}
//	}

}
