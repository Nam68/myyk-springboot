package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.account.CreateAccountForm;
import yk.web.myyk.backend.dto.form.account.CreateAccountInfoForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountCategoryHolder;
import yk.web.myyk.backend.dto.holder.account.CreateAccountHolder;
import yk.web.myyk.backend.dto.holder.account.CreateAccountInfoHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.service.account.CreateAccount;
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

    /**
     * <p>가계부 정보 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input/info")
    @SetEnum(target = {TaxRate.class, Currency.class})
    public String inputInfo(HttpServletRequest request) throws SystemException {
        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);
        setHolder(request, new CreateAccountInfoHolder(loginInfo));
        return "account/book/createAccountInputInfo";
    }

    @RequestMapping("/input/category")
    public String inputCategory(CreateAccountInfoForm form, HttpSession session, HttpServletRequest request) throws SystemException {

        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);
        CreateAccount logic = getService().getCreateAccount();
        try {
            logic.setAccountNameKr(form.getAccountNameKr());
            logic.setAccountNameJp(form.getAccountNameJp());
            logic.validate();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
            setHolder(request, new CreateAccountInfoHolder(loginInfo, form));
            return "account/book/createAccountInput";
        }
        setForm(session, form);

        // 회원이 가진 모든 카테고리를 반환.

        setHolder(request, new CreateAccountCategoryHolder());
        return "account/book/createAccountConfirm";
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
    public String confirm(CreateAccountForm form, HttpSession session, HttpServletRequest request) throws SystemException {

        FindAllMemberExceptMyself findMembers = getService().getFindAllMemberExceptMyself();
        findMembers.excute();

        FindAllMemberByIdx findReadAuthMembers = getService().getFindAllMemberByIdx();
        findReadAuthMembers.setMemberIdxList(form.getReadAuthList());
        findReadAuthMembers.excute();

        FindAllMemberByIdx findWriteAuthMembers = getService().getFindAllMemberByIdx();
        findWriteAuthMembers.setMemberIdxList(form.getWriteAuthList());
        findWriteAuthMembers.excute();

        CreateAccount logic = getService().getCreateAccount();
        try {
            logic.setAccountNameKr(form.getAccountNameKr());
            logic.setAccountNameJp(form.getAccountNameJp());
            logic.validate();
        } catch (AppException e) {
            setErrors(request, e.getErrors());
            setHolder(request, new CreateAccountHolder(findMembers.getMemberList(), form, findReadAuthMembers.getMemberList(), findWriteAuthMembers.getMemberList()));
            return "account/book/createAccountInput";
        }
        setForm(session, form);
        setHolder(request, new CreateAccountHolder(findMembers.getMemberList(), form, findReadAuthMembers.getMemberList(), findWriteAuthMembers.getMemberList()));
        return "account/book/createAccountConfirm";
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
    @DataCheck(target = CreateAccountForm.class)
    public String execute(HttpSession session, HttpServletRequest request) throws SystemException {

        FindAllMemberExceptMyself findMembers = getService().getFindAllMemberExceptMyself();
        findMembers.excute();

        CreateAccountForm form = getForm(session, CreateAccountForm.class);
        CreateAccount logic = getService().getCreateAccount();
        try {
            logic.setAccountNameKr(form.getAccountNameKr());
            logic.setAccountNameJp(form.getAccountNameJp());
            logic.setTaxInclude(form.isTaxInclude());
            logic.setTaxRate(form.getTaxRate());
            logic.setCurrency(form.getCurrency());
            logic.setReadAuthList(form.getReadAuthList());
            logic.setWriteAuthList(form.getWriteAuthList());
            logic.excute();
        } catch (AppException e) {
            setForm(session, form);
//            setHolder(request, new CreateAccountHolder(findMembers.getMemberList(), form));
            removeForm(session, CreateAccountForm.class);
            return "account/book/createAccountConfirm";
        }
        return "redirect:/account/book/create/complete";
    }

    /**
     * <p>가계부 생성 완료화면.</p>
     *
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(params = "/complete", method = RequestMethod.POST)
    @DataCheck(target = CreateAccountForm.class)
    @SessionClear
    public String complete() throws SystemException {
        return "redirect:/account/book/edit";
    }
}
