package yk.web.myyk.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.BaseMvc;
import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.factory.ServiceFactory;
import yk.web.myyk.util.errorCode.ErrorCode;

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

    /**
     * <p>화면에 빈 문자열을 출력할 때.</p>
     */
    protected static final String EMPTY = "";

    @Autowired
    private ServiceFactory serviceFactory;

    /**
     * <p>서비스팩토리를 반환한다.</p>
     *
     * @return 서비스팩토리
     */
    protected ServiceFactory getService() {
        return serviceFactory;
    }

    /**
     * <p>세션에 저장된 폼을 제거한다.</p>
     *
     * @param <T> {@link BaseForm}을 상속받은 폼
     * @param session 세션
     * @param form 폼
     */
    protected <T extends BaseForm> void removeForm(HttpSession session, T form) {
        removeForm(session, form.getClass());
    }

    /**
     * <p>세션에 저장된 폼을 제거한다.</p>
     *
     * @param <T> {@link BaseForm}을 상속받은 폼
     * @param session 세션
     * @param form 폼의 클래스
     */
    protected <T extends BaseForm> void removeForm(HttpSession session, Class<T> form) {

        String formName = form.getSimpleName();

        @SuppressWarnings("unchecked")
        T sessionForm = (T) session.getAttribute(formName);
        if (sessionForm != null) {
            session.removeAttribute(formName);
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

    /**
     * <p>리퀘스트에 홀더를 저장한다.</p>
     *
     * @param <T> {@link BaseHolder}
     * @param request 리퀘스트
     * @param holder 홀더
     */
    protected <T extends BaseHolder> void setHolder(HttpServletRequest request, T holder) {
        request.setAttribute(HOLDER, holder);
    }

    /**
     * <p>리퀘스트에 에러 리스트를 저장한다.</p>
     *
     * @param request 리퀘스트
     * @param errors 에러 리스트
     */
    protected void setErrors(HttpServletRequest request, Map<String, ErrorCode> errors) {
        request.setAttribute(ERRORS, errors);
    }

    /**
     * <p>DTO를 세션에 저장한다.</p>
     *
     * @param session 세션
     * @param dto DTO
     */
    protected <T> void setDTO(HttpSession session, T dto) {
        session.setAttribute(dto.getClass().getSimpleName(), dto);
    }

    /**
     * <p>세션에 저장된 DTO를 반환한다.</p>
     *
     * @param <T> DTO
     * @param session 세션
     * @param dto DTO
     * @return DTO
     */
    @SuppressWarnings("unchecked")
    protected <T> T getDTO(HttpSession session, Class<T> dto) {
        return (T) session.getAttribute(dto.getSimpleName());
    }
}
