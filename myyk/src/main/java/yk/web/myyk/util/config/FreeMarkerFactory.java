package yk.web.myyk.util.config;

import java.io.IOException;
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
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.mail.MailTemplateName;
import yk.web.myyk.util.mail.MailText;
import yk.web.myyk.util.mail.holder.BaseMailHolder;

/**
 * <p>HTML 메일에 사용될 프리마커 클래스.</p>
 */
@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FreeMarkerFactory {

    /**
     * <p>프리마커 관련 설정 등록.</p>
     */
    @Autowired
    private Configuration freemarker;

    /**
     * <p>템플레이트의 이름.<br>원칙 상, 모든 템플레이트는 같은 패키지에서 관리된다.</p>
     */
    private String templateName;

    /**
     * <p>프리마커 세팅용 맵.
     */
    private Map<String, Object> parameter = new HashMap<>();

    /**
     * <p>템플레이트 이름을 설정한다.
     * <br>모든 템플레이트 이름은 {@link MailTemplateName}에 등록해서 사용한다.</p>
     *
     * @param templateName 템플레이트 이름
     * @return 메일템플레이트
     */
    public FreeMarkerFactory setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    /**
     * <p>프리마커 변수를 설정한다.
     *
     * @param key 프리마커 템플레이트 상의 변수 이름
     * @param value 유저에게 보여지는 내용. 다언어대응을 위해 모든 값은 {@link MailText}에 등록한 후 사용한다.</p>
     * @return 템플레이트
     */
    public FreeMarkerFactory setParameter(String key, String value) {
        this.parameter.put(key, value);
        return this;
    }

    /**
     * <p>프리마커 변수를 설정한다.
     *
     * @param holder 유저에게 보여지는 내용.</p>
     * @return 템플레이트
     */
    public <T extends BaseHolder> FreeMarkerFactory setParameter(T holder) {
        this.parameter.put("holder", holder);
        return this;
    }

    /**
     * <p>프리마커 변수를 설정한다.
     *
     * @param holder 유저에게 보여지는 내용.</p>
     * @return 메일템플레이트
     */
    public <T extends BaseMailHolder> FreeMarkerFactory setParameter(T holder) {
        this.parameter.put("holder", holder);
        return this;
    }

    /**
     * <p>프리마커 변수를 설정한다.
     *
     * @param key 프리마커 템플레이트 상의 변수 이름
     * @param holder 유저에게 보여지는 내용.</p>
     * @return 메일템플레이트
     */
    public <T extends BaseHolder> FreeMarkerFactory setParameter(String key, T holder) {
        this.parameter.put(key, holder);
        return this;
    }

    /**
     * <p>프리마커를 랜더링해서 반환한다.</p>
     *
     * @return 랜더링된 프리머커
     */
    public String get() {
        Template template;
        try {
            template = freemarker.getTemplate(templateName);
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, parameter);
            return content;
        } catch (IOException e) {
            throw new SystemException(ErrorCode.MA_102, FreeMarkerFactory.class);
        } catch (TemplateException e) {
            throw new SystemException(ErrorCode.MA_103, FreeMarkerFactory.class);
        } finally {
            templateName = "";
            parameter = new HashMap<>();
        }
    }

}
