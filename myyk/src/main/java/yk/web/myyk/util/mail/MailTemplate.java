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
import yk.web.myyk.util.errorCode.ErrorCode;
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
     * <p>메일 정보가 담기는 클래스.</p>
     */
    private SimpleMailMessage message = new SimpleMailMessage();

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

    public MailTemplate setContent(String content) {
        message.setText(content);
        return this;
    }

    /**
     * <p>메일을 발송한다.</p>
     */
    public void send() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());

        try {
            helper.setTo(message.getTo());
            helper.setFrom(getAdminAddress());
            helper.setSubject(message.getSubject());
            helper.setText(message.getText(), true);

        } catch (MessagingException e) {
            throw new SystemException(ErrorCode.ME_101, MailTemplate.class);
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
    }

}
