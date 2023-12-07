package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.dto.holder.account.CreateAccountHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.annotation.SetEnum;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/account/book/create")
public class CreateAccountController extends BaseController {

    @RequestMapping("/input")
    @SetEnum(target = TaxRate.class)
    public String input(HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(LOGIN_INFO);
        List<MemberDto> list = getService().getMember().getAllExceptSelf(loginInfo);
        request.setAttribute(HOLDER, new CreateAccountHolder(list));
        return "account/book/createAccountInput";
    }

    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    @SetEnum(target = TaxRate.class)
    public String confirm() throws SystemException {
        return "account/book/createAccountConfirm";
    }

    @RequestMapping(path = "/execute", method = RequestMethod.POST)
    @DataCheck()
    public String execute() throws SystemException {
        return "redirect:/account/book/complete";
    }

    @RequestMapping(params = "/complete", method = RequestMethod.POST)
    @DataCheck()
    @SessionClear
    public String complete() throws SystemException {
        return "account/book/createAccountComplete";
    }
}
