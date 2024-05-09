package yk.web.myyk.backend.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.login.LoginForm;
import yk.web.myyk.backend.dto.holder.login.LoginHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.login.Login;
import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>로그인 컨트롤러.</p>
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static final String HOMEPAGE = "/";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";
    private static final String INPUT = "login/loginInput";

    /**
     * <p>로그인 입력 화면.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input")
    public String input(HttpSession session, HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = getLoginInfo(LoginController.class);
        if (loginInfo != null) {
            return HOMEPAGE;
        }
        setHolder(request, new LoginHolder());
        return INPUT;
    }

    /**
     * <p>로그인 확인.</p>
     *
     * @param form 로그인 폼
     * @param session 세션
     * @param request 리퀘스트
     * @param response 리스폰스
     * @return 리다이렉트
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public String confirm(LoginForm form, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws SystemException {

        Login logic = getService().getLogin();
        try {
            logic.setEmail(form.getEmail());
            logic.setPassword(form.getPassword());
            logic.setAutoLogin(form.isAutoLogin());
            logic.excute();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
            setHolder(request, new LoginHolder(form));
            return INPUT;
        }
        session.setAttribute(LOGIN_INFO, logic.getCreatedLoginInfo());
        String tokenId = logic.getCreatedTokenId();
        if (tokenId != null && !"".equals(tokenId)) {
            CookieUtil.setCookie(AUTO_LOGIN, encrypt(tokenId), response);
        }
        return HOMEPAGE_REDIRECT;
    }

    /**
     * <p>로그아웃.</p>
     *
     * @param session 세션
     * @param response 리스폰스
     * @return 리다이렉트
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/logout")
    public String logout(HttpSession session, HttpServletResponse response) throws SystemException {
        session.removeAttribute(LOGIN_INFO);
        CookieUtil.deleteCookie(AUTO_LOGIN, response);
        return HOMEPAGE_REDIRECT;
    }
}
