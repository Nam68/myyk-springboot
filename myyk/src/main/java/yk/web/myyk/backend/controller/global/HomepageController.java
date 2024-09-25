package yk.web.myyk.backend.controller.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.controller.account.CreateAccountBookCategoryController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookCategoryHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.account.FindAccountBookByWriteAuth;
import yk.web.myyk.backend.service.category.SearchBasicCategory;
import yk.web.myyk.backend.service.category.SearchCategoryByMember;
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

        LoginInfo loginInfo = getLoginInfo(HomepageController.class);

        // 쓰기 권한을 가진 가계부 DTO를 검색
        FindAccountBookByWriteAuth accountLogic = getService().getFindBookByWriteAuth();
        accountLogic.setAccountBookIdx(2);
        accountLogic.setMemberIdx(loginInfo.getMemberIdx());
        accountLogic.excute();
        AccountBookDTO dto = accountLogic.getAccountBook();

        // 기본 카테고리를 검색
        SearchBasicCategory basicCategoryLogic = getService().getSearchBasicCategory();
        basicCategoryLogic.excute();
        List<CategoryDTO> basicCategoryList = basicCategoryLogic.getBasicCategory();

        // 작성한 카테고리를 검색
        SearchCategoryByMember createdCategoryLogic = getService().getSearchCategoryByMember();
        createdCategoryLogic.setLocale(getCurrentLocale(CreateAccountBookCategoryController.class));
        createdCategoryLogic.setMemberIdx(loginInfo.getMemberIdx());
        createdCategoryLogic.setNeedSubCategory(true);
        createdCategoryLogic.excute();
        List<CategoryDTO> createdCategoryList = createdCategoryLogic.getCategoryList();

        CreateAccountBookCategoryHolder holder = new CreateAccountBookCategoryHolder(dto, basicCategoryList, createdCategoryList);

        // 가짜 선택자
        Map<String, Boolean> selectedCategory = new HashMap<>();
        selectedCategory.put("1", true);
        selectedCategory.put("2", true);

        Map<String, Boolean> selectedSubCategory = new HashMap<>();
        selectedSubCategory.put("2", true);

        holder.setSelectedCategory(selectedCategory);
        holder.setSelectedSubCategory(selectedSubCategory);

        setHolder(request, holder);
        return "test/sample";
    }
}
