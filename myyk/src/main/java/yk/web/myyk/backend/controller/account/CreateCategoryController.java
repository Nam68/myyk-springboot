package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.account.CreateCategoryForm;
import yk.web.myyk.backend.dto.holder.account.CreateCategoryHolder;
import yk.web.myyk.backend.service.account.CreateCategory;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/category/create")
public class CreateCategoryController extends BaseController {

    private static final String INPUT = "account/category/createCategoryInput";
    private static final String CONFIRM = "account/category/createCategoryConfirm";

    /**
     * <p>카테고리 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템 에러
     */
    @RequestMapping("/input")
    public String input(HttpServletRequest request) throws SystemException {
        setHolder(request, new CreateCategoryHolder());
        return INPUT;
    }

    /**
     * <p>카테고리 생성 확인화면.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @param form 폼
     * @return 뷰 이름
     * @throws SystemException 시스템 에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public String confirm(CreateCategoryForm form, HttpSession session, HttpServletRequest request) throws SystemException {

        CreateCategory logic = getService().getCreateCategory();
        try {
            setAllParameters(logic, form);
            logic.validate();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
            setHolder(request, new CreateCategoryHolder(form));
            return INPUT;
        }
        setForm(session, form);
        setHolder(request, new CreateCategoryHolder(form));
        return CONFIRM;
    }

    /**
     * <p>카테고리 생성.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @return 리다이렉트
     * @throws SystemException 시스템 에러
     */
    @RequestMapping(path = "/excute", method = RequestMethod.POST)
    @DataCheck(target = CreateCategoryForm.class)
    public String excute(HttpSession session, HttpServletRequest request) throws SystemException {
        CreateCategory logic = getService().getCreateCategory();
        CreateCategoryForm form = getForm(session, CreateCategoryForm.class);
        try {
            setAllParameters(logic, form);
            logic.excute();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
            setHolder(request, new CreateCategoryHolder(form));
            return CONFIRM;
        }
        return "redirect:/account/category/create/complete";
    }

    /**
     * <p>카테고리 생성 완료화면.</p>
     *
     * @return 리다이렉트
     * @throws SystemException 시스템 에러
     */
    @RequestMapping(path = "/complete", method = RequestMethod.POST)
    @SessionClear
    public String complete() throws SystemException {
        return "redirect:/account/category/sub/create/input";
    }

    /**
     * <p>로직에 필요한 모든 변수를 설정한다.</p>
     *
     * @param logic 로직
     * @param form 폼
     */
    private void setAllParameters(CreateCategory logic, CreateCategoryForm form) {
        logic.setCategoryNameKo(form.getCategoryNameKo());
        logic.setCategoryNameJp(form.getCategoryNameJp());
        logic.setCategoryIcon(form.getCategoryIcon());
        logic.setCategoryColor(form.getCategoryColor());
    }
}
