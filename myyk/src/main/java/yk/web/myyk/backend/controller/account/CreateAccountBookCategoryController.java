package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookCategoryForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookCategoryHolder;
import yk.web.myyk.backend.service.account.FindAccountBookByWriteAuth;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>가계부의 카테고리 리스트를 작성하는 컨트롤러.</p>
 */
@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/book/create/category")
public class CreateAccountBookCategoryController extends BaseController {

    private static final String INPUT = "account/book/createAccountBookCategoryInput";

    /**
     * <p>가계부의 카테고리 리스트 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @param session 세션
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/input", method = RequestMethod.POST)
    public String input(HttpServletRequest request, CreateAccountBookCategoryForm form) throws SystemException {

        // 쓰기 권한을 가진 가계부 DTO를 검색
        // 에러인 경우 그대로 에러 화면으로 넘어가면 되므로 try-catch 불필요
        FindAccountBookByWriteAuth accountLogic = getService().getFindBookByWriteAuth();
        accountLogic.setAccountBookIdx(form.getAccountBookIdx());
        accountLogic.excute();
        AccountBookDTO dto = accountLogic.getAccountBook();

        // 기본 카테고리를 검색

        CreateAccountBookCategoryHolder holder = new CreateAccountBookCategoryHolder(dto);
        setHolder(request, holder);
        return INPUT;
    }

    /**
     * <p>가계부의 카테고리 리스트 생성 수정화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request /*HOLDER*/) throws SystemException {
//        setHolder(request, holder);
        return INPUT;
    }
}
