package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.holder.account.AccountBookEditHolder;
import yk.web.myyk.backend.dto.holder.account.CategoryEditHolder;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
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
        setHolder(request, new AccountBookEditHolder());
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
    public String accountBookEdit(HttpServletRequest request) throws SystemException {
        setHolder(request, new AccountBookEditHolder());
        return "account/book/accountBookEdit";
    }

    /**
     * <p>카테고리 에디터 화면</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/category/edit")
    public String categoryEdit(HttpServletRequest request) throws SystemException {
        setHolder(request, new CategoryEditHolder());
        return "account/category/categoryEdit";
    }
}
