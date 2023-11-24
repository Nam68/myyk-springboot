package yk.web.myyk.backend.controller;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.BaseMvc;
import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.backend.factory.ServiceFactory;

/**
 * <p>기본 컨트롤러.</p>
 */
public class BaseController extends BaseMvc {

    /**
     * <p>화면 출력 값.</p>
     */
    protected static final String HOLDER = "holder";

    /**
     * <p>화면에 출력할 에러.</p>
     */
    protected static final String ERRORS = "errors";

    @Autowired
    private ServiceFactory serviceFactory;

    /**
     * <p>서비스팩토리를 가져온다.</p>
     *
     * @return 서비스팩토리
     */
    protected ServiceFactory getService() {
        return serviceFactory;
    }

    /**
     * <p>세션에 저장된 모든 폼을 삭제한다.</p>
     * 
     * @param session 세션
     */
    protected void removeAllForm(HttpSession session) {
        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            if (session.getAttribute(name) instanceof BaseForm) {
                session.removeAttribute(name);
            }
        }
    }

    /**
     * <p>폼을 세션에 저장한다.</p>
     * 
     * @param <T> {@link BaseForm}
     * @param session 세션
     * @param form 폼
     */
    protected <T extends BaseForm> void setForm(HttpSession session, T form) {
        session.setAttribute(form.getClass().getSimpleName(), form);
    }

    /**
     * <p>세션에서 폼을 가져온다.</p>
     * 
     * @param <T> {@link BaseForm}
     * @param session 세션
     * @param form 폼 클래스
     * @return 폼
     */
    @SuppressWarnings("unchecked")
    protected <T extends BaseForm> T getForm(HttpSession session, Class<T> form) {
        return (T) session.getAttribute(form.getSimpleName());
    }

}
