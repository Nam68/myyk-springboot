package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
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
    @DataCheck(target = AccountBookDTO.class)
    @SessionClear
    public String input(HttpServletRequest request, HttpSession session) throws SystemException {
        AccountBookDTO dto = getDTO(session, AccountBookDTO.class);
//        setHolder(request, new CreateAccountBookHolder(dto)); // 전용 홀더 작성
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
