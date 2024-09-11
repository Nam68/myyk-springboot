package yk.web.myyk.backend.controller.global;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookCategoryHolder;
import yk.web.myyk.backend.service.account.FindAccountBookByWriteAuth;
import yk.web.myyk.backend.service.category.SearchBasicCategory;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>홈페이지 컨트롤러.</p>
 */
@Controller
public class HomepageController extends BaseController {

    private static final String HOMEPAGE = "homepage";

    /**
     * <p>홈페이지 화면.</p>
     *
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping({"/", "/homepage"})
    public String index() throws SystemException {
        return HOMEPAGE;
    }

    /**
     * <p>비밀번호를 리셋한다.</p>
     *
     * @param email 대상 이메일
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/member/update/passwordReset", method = RequestMethod.POST)
    public String passwordReset(MemberForm memberForm) throws SystemException {
//        getService().getMember().resetPassword(memberForm);
        return HOMEPAGE;
    }

    @RequestMapping("/sample")
    public String sample(HttpServletRequest request) throws SystemException {

        FindAccountBookByWriteAuth logic = getService().getFindBookByWriteAuth();
        logic.setAccountBookIdx(1);
        logic.excute();
        AccountBookDTO dto = logic.getAccountBook();

        SearchBasicCategory basicCategoryLogic = getService().getSearchBasicCategory();
        basicCategoryLogic.excute();
        List<CategoryDTO> basicCategoryList = basicCategoryLogic.getBasicCategory();

        CreateAccountBookCategoryHolder holder = new CreateAccountBookCategoryHolder(dto, basicCategoryList);
        setHolder(request, holder);
        return "test/sample";
    }
}
