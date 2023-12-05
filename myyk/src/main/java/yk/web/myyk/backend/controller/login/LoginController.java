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
import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>로그인 컨트롤러.</p>
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

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
        LoginInfo loginInfo = (LoginInfo) session.getAttribute(LOGIN_INFO);
        if (loginInfo != null) {
            return "/";
        }
        request.setAttribute(HOLDER, new LoginHolder());
        return "login/loginInput";
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
        try {
            LoginInfo loginInfo = getService().getLogin().getLoginInfo(form);
            session.setAttribute(LOGIN_INFO, loginInfo);

            if (form.isAutoLogin()) {
                String tokenId = getService().getLogin().createLoginToken(loginInfo);
                CookieUtil.setCookie(AUTO_LOGIN, encrypt(tokenId), response);
            }
            return "redirect:/";
        } catch (AppException e) {
            request.setAttribute(ERRORS, e.getErrors());
            request.setAttribute(HOLDER, new LoginHolder(form));
            return "login/loginInput";
        }
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
        return "redirect:/";
    }
}
