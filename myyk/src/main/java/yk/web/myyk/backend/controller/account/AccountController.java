package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.holder.account.AccountMainHolder;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    /**
     * <p>가계부 메인 화면.</p>
     * 
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping
    public String main(HttpServletRequest request) throws SystemException {
        request.setAttribute(HOLDER, new AccountMainHolder());
        return "account/main";
    }

    /**
     * <p>가계부 에디터 화면.</p>
     * 
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/book/edit")
    public String edit(HttpServletRequest request) throws SystemException {
        request.setAttribute(HOLDER, new AccountMainHolder());
        return "account/book/edit";
    }
}
