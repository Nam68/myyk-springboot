package yk.web.myyk.backend.controller.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookCategoryForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookCategoryHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.account.CreateAccountBookCategory;
import yk.web.myyk.backend.service.account.FindAccountBookByWriteAuth;
import yk.web.myyk.backend.service.category.SearchBasicCategory;
import yk.web.myyk.backend.service.category.SearchCategoryByMember;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>가계부의 카테고리 리스트를 작성하는 컨트롤러.</p>
 */
@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/book/create/category")
public class CreateAccountBookCategoryController extends BaseController {

    private static final String INPUT = "account/book/createAccountBookCategoryInput";
    private static final String CONFIRM = "account/book/createAccountBookCategoryConfirm";
    private static final String COMPLETE = "account/book/createAccountBookCategoryComplete";
    private static final String COMPLETE_REDIRECT = "redirect:/account/book/create/category/complete";

    /**
     * <p>가계부의 카테고리 리스트 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @param form 폼
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/input", method = RequestMethod.POST)
    public String input(HttpServletRequest request, CreateAccountBookCategoryForm form) throws SystemException {

        // 에러인 경우 그대로 에러 화면으로 넘어가면 되므로 try-catch 불필요
        // 쓰기권한이 없거나 하는 경우가 정상 조작이면 있을 수 없으므로 에러화면으로 넘겨도 됨

        LoginInfo loginInfo = getLoginInfo(CreateAccountBookCategoryController.class);

        CreateAccountBookCategoryHolder holder = createHolder(form.getAccountBookIdx(), loginInfo.getMemberIdx());
        setHolder(request, holder);
        return INPUT;
    }

    /**
     * <p>가계부의 카테고리 리스트 생성 확인화면.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @param form 폼
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public String confirm(HttpSession session, HttpServletRequest request, CreateAccountBookCategoryForm form) throws SystemException {

        LoginInfo loginInfo = getLoginInfo(CreateAccountBookCategoryController.class);

        try {
            CreateAccountBookCategory logic = getService().getCreateAccountBookCategory();
            logic.setAccountBookIdx(form.getAccountBookIdx());
            logic.setCategoryIdxList(form.getCategoryIdx());
            logic.setSubCategoryIdxList(form.getSubCategoryIdx());
            logic.validate();
        } catch (AppException e) {
            setHolder(request, createHolderWithCategory(form, loginInfo.getMemberIdx()));
            setErrors(request, e.getErrors());
            return INPUT;
        }
        setForm(session, form);
        setHolder(request, createHolderWithCategory(form, loginInfo.getMemberIdx()));
        return CONFIRM;
    }

    /**
     * <p>가계부의 카테고리 리스트 생성.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @return 리다이렉트
     * @throws SystemException 시스템 에러
     */
    @RequestMapping(path = "/excute", method = RequestMethod.POST)
    @DataCheck(target = CreateAccountBookCategoryForm.class)
    public String excute(HttpSession session, HttpServletRequest request) throws SystemException {

        CreateAccountBookCategoryForm form = getForm(session, CreateAccountBookCategoryForm.class);
        LoginInfo loginInfo = getLoginInfo(CreateAccountBookCategoryController.class);

        try {
            CreateAccountBookCategory logic = getService().getCreateAccountBookCategory();
            logic.setAccountBookIdx(form.getAccountBookIdx());
            logic.setCategoryIdxList(form.getCategoryIdx());
            logic.setSubCategoryIdxList(form.getSubCategoryIdx());
            logic.excute();

            setDTO(session, logic.getAccountBook());

        } catch (AppException e) {
            setHolder(request, createHolderWithCategory(form, loginInfo.getMemberIdx()));
            setErrors(request, e.getErrors());
            removeForm(session, CreateAccountBookCategoryForm.class);
            return CONFIRM;
        }
        return COMPLETE_REDIRECT;
    }

    /**
     * <p>가계부의 카테고리 리스트 완료화면.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/complete", method = RequestMethod.POST)
    @DataCheck(target = AccountBookDTO.class)
    @SessionClear
    public String complete(HttpSession session, HttpServletRequest request) throws SystemException {
        AccountBookDTO dto = getDTO(session, AccountBookDTO.class);
        CreateAccountBookCategoryHolder holder = new CreateAccountBookCategoryHolder(dto);
        setHolder(request, holder);
        return COMPLETE;
    }

    /**
     * <p>홀더 생성.</p>
     *
     * @param accountBookIdx
     * @param memberIdx
     * @return
     */
    private CreateAccountBookCategoryHolder createHolder(long accountBookIdx, long memberIdx) {

        // 쓰기 권한을 가진 가계부 DTO를 검색
        FindAccountBookByWriteAuth accountLogic = getService().getFindBookByWriteAuth();
        accountLogic.setAccountBookIdx(accountBookIdx);
        accountLogic.setMemberIdx(memberIdx);
        accountLogic.excute();
        AccountBookDTO dto = accountLogic.getAccountBook();

        // 기본 카테고리를 검색
        SearchBasicCategory basicCategoryLogic = getService().getSearchBasicCategory();
        basicCategoryLogic.excute();
        List<CategoryDTO> basicCategoryList = basicCategoryLogic.getBasicCategory();

        // 작성한 카테고리를 검색
        SearchCategoryByMember memberCategoryLogic = getService().getSearchCategoryByMember();
        memberCategoryLogic.setLocale(getCurrentLocale(CreateAccountBookCategoryController.class));
        memberCategoryLogic.setMemberIdx(memberIdx);
        memberCategoryLogic.setNeedSubCategory(true);
        memberCategoryLogic.excute();
        List<CategoryDTO> memberCategoryList = memberCategoryLogic.getCategoryList();

        return new CreateAccountBookCategoryHolder(dto, basicCategoryList, memberCategoryList);
    }

    /**
     * <p>선택된 카테고리를 포함한 홀더 생성.</p>
     *
     * @param accountBookIdx
     * @param memberIdx
     * @param categoryIdxList
     * @param subCategoryIdxList
     * @return
     */
    private CreateAccountBookCategoryHolder createHolderWithCategory(CreateAccountBookCategoryForm form, long memberIdx) {
        CreateAccountBookCategoryHolder holder = createHolder(form.getAccountBookIdx(), memberIdx);
        setSelectedCategory(holder, form.getCategoryIdx());
        setSelectedSubCategory(holder, form.getSubCategoryIdx());
        return holder;
    }

    /**
     * <p>홀더에 선택된 카테고리를 설정한다.</p>
     *
     * @param holder
     * @param selectedCategoryIdxList
     */
    private void setSelectedCategory(CreateAccountBookCategoryHolder holder, List<Long> selectedCategoryIdxList) {
        Map<String, Boolean> selectedCategory = new HashMap<>();
        for (long categoryIdx : selectedCategoryIdxList) {
            selectedCategory.put(String.valueOf(categoryIdx), true);
        }
        holder.setSelectedCategory(selectedCategory);
    }

    /**
     * <p>홀더에 선택된 서브 카테고리를 설정한다.</p>
     *
     * @param holder
     * @param selectedSubCategoryIdxList
     */
    private void setSelectedSubCategory(CreateAccountBookCategoryHolder holder, List<Long> selectedSubCategoryIdxList) {
        Map<String, Boolean> selectedSubCategory = new HashMap<>();
        for (long subCategoryIdx : selectedSubCategoryIdxList) {
            selectedSubCategory.put(String.valueOf(subCategoryIdx), true);
        }
        holder.setSelectedSubCategory(selectedSubCategory);
    }
}
