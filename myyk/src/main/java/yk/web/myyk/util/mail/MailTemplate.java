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

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MailTemplate extends MailConfig {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Configuration config;
	
	private SimpleMailMessage message = new SimpleMailMessage();
	
	private String templateName;
	
	private Map<String, Object> parameter = new HashMap<>();
	
	public MailTemplate setTo(String to) {
		message.setTo(to);
		return this;
	}
	
	public MailTemplate setSubject(String subject) {
		message.setSubject(subject);
		return this;
	}
	
	public MailTemplate setTemplateName(String templateName) {
		this.templateName = templateName;
		return this;
	}
	
	public MailTemplate setParameter(String key, String value) {
		this.parameter.put(key, value);
		return this;
	}
	
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
	
	public void sendPlain() {
		message.setFrom(getAdminAddress());
		mailSender.send(message);
		clear();
	}
	
	
	private void clear() {
		message.setTo("");
		message.setFrom("");
		message.setSubject("");
		templateName = "";
		parameter = new HashMap<>();
	}


}
