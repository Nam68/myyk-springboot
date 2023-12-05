package yk.web.myyk.backend.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.login.LoginForm;
import yk.web.myyk.backend.dto.holder.login.LoginHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.constant.KeyName;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>로그인 컨트롤러.</p>
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @RequestMapping("/input")
    public String input(HttpSession session, HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = (LoginInfo) session.getAttribute(KeyName.LOGIN_INFO);
        if (loginInfo != null) {
            return "/";
        }
        request.setAttribute(HOLDER, new LoginHolder());
        return "login/loginInput";
    }

    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public String confirm(LoginForm form, HttpSession session, HttpServletRequest request) throws SystemException {
        try {
            LoginInfo loginInfo = getService().getLogin().getLoginInfo(form);
            session.setAttribute(KeyName.LOGIN_INFO, loginInfo);
            return "/";
        } catch (AppException e) {
            request.setAttribute(ERRORS, e.getErrors());
            request.setAttribute(HOLDER, new LoginHolder(form));
            return "login/loginInput";
        }
    }
}
