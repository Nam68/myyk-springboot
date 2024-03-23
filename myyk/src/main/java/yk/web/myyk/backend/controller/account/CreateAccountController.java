package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.dto.form.account.CreateAccountForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.annotation.SetEnum;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/account/book/create")
public class CreateAccountController extends BaseController {

    /**
     * <p>가계부 생성 입력화면.</p>
     * 
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input")
    @SetEnum(target = {TaxRate.class, Currency.class})
    public String input(HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(LOGIN_INFO);
        List<MemberDto> list = getService().getMember().getAllExceptSelf(loginInfo);
        request.setAttribute(HOLDER, new CreateAccountHolder(loginInfo, list));
        return "account/book/createAccountInput";
    }

    /**
     * <p>가계부 생성 확인화면.</p>
     * 
     * @param form 폼
     * @param session 세션
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    @SetEnum(target = {TaxRate.class, Currency.class})
    public String confirm(CreateAccountForm form, HttpSession session, HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(LOGIN_INFO);
        List<MemberDto> list = getService().getMember().getAllExceptSelf(loginInfo);
        request.setAttribute(HOLDER, new CreateAccountHolder(list, form));
        try {
            getService().getAccount().checkAccount(form);
            setForm(session, form);
            return "account/book/createAccountConfirm";
        } catch (AppException e) {
            request.setAttribute(ERRORS, e.getErrors());
            return "account/book/createAccountInput";
        }
    }

    @RequestMapping(path = "/execute", method = RequestMethod.POST)
    @DataCheck(target = CreateAccountForm.class)
    public String execute(HttpSession session) throws SystemException {
        CreateAccountForm form = getForm(session, CreateAccountForm.class);
        getService().getAccount().createAccount(form);
        return "redirect:/account/book/create/complete";
    }

    @RequestMapping(params = "/complete", method = RequestMethod.POST)
    @DataCheck(target = CreateAccountForm.class)
    @SessionClear
    public String complete() throws SystemException {
        return "account/book/createAccountComplete";
    }
}
