package yk.web.myyk.util.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import yk.web.myyk.util.config.MailConfig;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>메일 관련 템플레이트.</p>
 */
@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MailTemplate extends MailConfig {
	
	/**
	 * <p>메일 샌더.</p>
	 */
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * <p>프리마커 관련 설정 등록.</p>
	 */
	@Autowired
	private Configuration config;
	
	/**
	 * <p>메일 정보가 담기는 클래스.</p>
	 */
	private SimpleMailMessage message = new SimpleMailMessage();
	
	/**
	 * <p>템플레이트의 이름.<br>원칙 상, 모든 템플레이트는 같은 패키지에서 관리된다.</p>
	 */
	private String templateName;
	
	/**
	 * <p>프리마커 세팅용 맵.
	 */
	private Map<String, Object> parameter = new HashMap<>();
	
	/**
	 * <p>메일의 수신자를 설정한다.</p>
	 * 
	 * @param to 수신자
	 * @return 메일템플레이트
	 */
	public MailTemplate setTo(String to) {
		message.setTo(to);
		return this;
	}
	
	/**
	 * <p>메일의 제목을 설정한다.</p>
	 * 
	 * @param subject 제목
	 * @return 메일템플레이트
	 */
	public MailTemplate setSubject(String subject) {
		message.setSubject(subject);
		return this;
	}
	
	/**
	 * <p>템플레이트 이름을 설정한다. 
	 * <br>모든 템플레이트 이름은 {@link MailTemplateName}에 등록해서 사용한다.</p>
	 * 
	 * @param templateName 템플레이트 이름
	 * @return 메일템플레이트
	 */
	public MailTemplate setTemplateName(String templateName) {
		this.templateName = templateName;
		return this;
	}
	
	/**
	 * <p>프리마커 변수를 설정한다.
	 * 
	 * @param key 프리마커 템플레이트 상의 변수 이름
	 * @param value 유저에게 보여지는 내용. 다언어대응을 위해 모든 값은 {@link MailText}에 등록한 후 사용한다.</p>
	 * @return 메일템플레이트
	 */
	public MailTemplate setParameter(String key, String value) {
		this.parameter.put(key, value);
		return this;
	}
	
	/**
	 * <p>메일을 발송한다.</p>
	 */
	public void send() {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(
				mimeMessage, 
				StandardCharsets.UTF_8.name());
		
		try {
			Template template = config.getTemplate(templateName);
	        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, parameter);
	        
			helper.setTo(message.getTo());
			helper.setFrom(getAdminAddress());
			helper.setSubject(message.getSubject());
			helper.setText(content, true);
			
		} catch (MessagingException | IOException | TemplateException e) {
			throw new SystemException(e.getMessage());
		}

		mailSender.send(mimeMessage);
		clear();
	}
	
	/**
	 * <p>HTML을 사용하지 않는 메일을 발송한다.<p>
	 */
	public void sendPlain() {
		message.setFrom(getAdminAddress());
		mailSender.send(message);
		clear();
	}
	
	/**
	 * <p>메일 발송 후 조건을 초기화하는 메서드. 메일 발송 후 반드시 사용해야 한다.</p>
	 */
	private void clear() {
		message.setTo("");
		message.setFrom("");
		message.setSubject("");
		templateName = "";
		parameter = new HashMap<>();
	}


}
