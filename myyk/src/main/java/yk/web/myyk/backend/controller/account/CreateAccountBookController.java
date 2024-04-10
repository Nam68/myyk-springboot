package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookForm;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookInfoForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookInfoHolder;
import yk.web.myyk.backend.dto.holder.account.CreateCategoryHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.account.CreateAccountBook;
import yk.web.myyk.backend.service.member.FindAllMemberByIdx;
import yk.web.myyk.backend.service.member.FindAllMemberExceptMyself;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.annotation.SetEnum;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/book/create")
public class CreateAccountBookController extends BaseController {

    private static final String INFO_INPUT_VIEW = "account/book/createAccountBookInfoInput";
    private static final String INFO_CONFIRM_VIEW = "account/book/createAccountBookInfoConfirm";
    private static final String COMPLETE_REDIRECT = "redirect:/account/book/create/complete";
    private static final String EDIT_REDIRECT = "redirect:/account/book/edit";

    /**
     * <p>가계부 정보 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/info/input")
    @SetEnum(target = {TaxRate.class, Currency.class})
    public String inputInfo(HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);
        setHolder(request, new CreateAccountBookInfoHolder(loginInfo));
        return INFO_INPUT_VIEW;
    }

    @RequestMapping(path = "/input/category", method = RequestMethod.POST)
    public String inputCategory(CreateAccountBookInfoForm form, HttpSession session, HttpServletRequest request) throws SystemException {

        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);
        CreateAccountBook logic = getService().getCreateAccountBook();
        try {
            logic.setAccountBookNameKo(form.getAccountBookNameKo());
            logic.setAccountBookNameJp(form.getAccountBookNameJp());
            logic.validate();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
            setHolder(request, new CreateAccountBookInfoHolder(loginInfo, form));
            return INFO_INPUT_VIEW;
        }
        setForm(session, form);

        // 회원이 가진 모든 카테고리를 반환.

        setHolder(request, new CreateCategoryHolder());
        return INFO_CONFIRM_VIEW;
    }

    /**
     * <p>가계부 생성 확인화면.</p>
     *
     * @param form 폼
     * @param session 세션
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    @SetEnum(target = {TaxRate.class, Currency.class})
    public String confirm(CreateAccountBookForm form, HttpSession session, HttpServletRequest request) throws SystemException {

        FindAllMemberExceptMyself findMembers = getService().getFindAllMemberExceptMyself();
        findMembers.excute();

        FindAllMemberByIdx findReadAuthMembers = getService().getFindAllMemberByIdx();
        findReadAuthMembers.setMemberIdxList(form.getReadAuthList());
        findReadAuthMembers.excute();

        FindAllMemberByIdx findWriteAuthMembers = getService().getFindAllMemberByIdx();
        findWriteAuthMembers.setMemberIdxList(form.getWriteAuthList());
        findWriteAuthMembers.excute();

        CreateAccountBook logic = getService().getCreateAccountBook();
        try {
            logic.setAccountBookNameKo(form.getAccountBookNameKo());
            logic.setAccountBookNameJp(form.getAccountBookNameJp());
            logic.validate();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
//            setHolder(request, new CreateAccountBookInfoHolder(findMembers.getMemberList(), form, findReadAuthMembers.getMemberList(), findWriteAuthMembers.getMemberList()));
            return INFO_INPUT_VIEW;
        }
        setForm(session, form);
//        setHolder(request, new CreateAccountBookInfoHolder(findMembers.getMemberList(), form, findReadAuthMembers.getMemberList(), findWriteAuthMembers.getMemberList()));
        return INFO_CONFIRM_VIEW;
    }

    /**
     * <p>가계부 생성.</p>
     *
     * @param session 세션
     * @param request 리퀘스트
     * @return 리다이렉트
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/execute", method = RequestMethod.POST)
    @DataCheck(target = CreateAccountBookForm.class)
    public String execute(HttpSession session, HttpServletRequest request) throws SystemException {

        FindAllMemberExceptMyself findMembers = getService().getFindAllMemberExceptMyself();
        findMembers.excute();

        CreateAccountBookForm form = getForm(session, CreateAccountBookForm.class);
        CreateAccountBook logic = getService().getCreateAccountBook();
        try {
            logic.setAccountBookNameKo(form.getAccountBookNameKo());
            logic.setAccountBookNameJp(form.getAccountBookNameJp());
            logic.setTaxInclude(form.isTaxInclude());
            logic.setTaxRate(form.getTaxRate());
            logic.setCurrency(form.getCurrency());
            logic.setReadAuthList(form.getReadAuthList());
            logic.setWriteAuthList(form.getWriteAuthList());
            logic.excute();
        } catch (AppException e) {
            setForm(session, form);
//            setHolder(request, new CreateAccountHolder(findMembers.getMemberList(), form));
            removeForm(session, CreateAccountBookForm.class);
            return INFO_CONFIRM_VIEW;
        }
        return COMPLETE_REDIRECT;
    }

    /**
     * <p>가계부 생성 완료화면.</p>
     *
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(params = "/complete", method = RequestMethod.POST)
    @DataCheck(target = CreateAccountBookForm.class)
    @SessionClear
    public String complete() throws SystemException {
        return EDIT_REDIRECT;
    }
}
