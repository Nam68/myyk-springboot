package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.holder.account.AccountBookEditHolder;
import yk.web.myyk.backend.dto.holder.account.CategoryEditHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.category.SearchCategoryByMember;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account")
public class AccountController extends BaseController {

    private static final String MAIN = "account/main";
    private static final String ACCOUNT_BOOK_EDIT = "account/book/accountBookEdit";
    private static final String CATEGORY_EDIT = "account/category/categoryEdit";

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
        return MAIN;
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
        return ACCOUNT_BOOK_EDIT;
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

        LoginInfo loginInfo = getLoginInfo(AccountController.class);

        SearchCategoryByMember logic = getService().getSearchCategoryByMember();

        logic.setLocale(getCurrentLocale(AccountController.class));
        logic.setMemberIdx(loginInfo.getMemberIdx());
        logic.setNeedSubCategory(false);
        logic.excute();
        List<CategoryDTO> list = logic.getCategoryList();

        setHolder(request, new CategoryEditHolder(list));
        return CATEGORY_EDIT;
    }
}
