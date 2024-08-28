package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookHolder;
import yk.web.myyk.backend.dto.holder.category.CreateCategoryHolder;
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

    private static final String INPUT = "account/book/createAccountBookInput";
    private static final String CONFIRM = "account/book/createAccountBookConfirm";
    private static final String COMPLETE_REDIRECT = "redirect:/account/book/create/complete";
    private static final String EDIT_REDIRECT = "redirect:/account/book/edit";

    /**
     * <p>가계부 정보 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input")
    @SetEnum(target = {Currency.class})
    public String inputInfo(HttpServletRequest request) throws SystemException {

        // 로그인 정보
        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);

        // 본인 이외의 회원 리스트
        List<MemberDTO> memberList = getMemberListExceptLoginedMember();

        setHolder(request, new CreateAccountBookHolder(loginInfo, memberList));
        return INPUT;
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
    @SetEnum(target = {Currency.class})
    public String confirm(CreateAccountBookForm form, HttpSession session, HttpServletRequest request) throws SystemException {

        FindAllMemberByIdx findreadAuthList = getService().getFindAllMemberByIdx();
        FindAllMemberByIdx findwriteAuthList = getService().getFindAllMemberByIdx();

        CreateAccountBook logic = getService().getCreateAccountBook();
        try {
            findreadAuthList.setMemberIdxList(form.getReadAuthList());
            findreadAuthList.excute();

            findwriteAuthList.setMemberIdxList(form.getWriteAuthList());
            findwriteAuthList.excute();

            setAllParameters(logic, form);
            logic.validate();
        } catch (AppException e) {
            // 본인 이외의 회원 리스트
            List<MemberDTO> memberList = getMemberListExceptLoginedMember();

            setErrors(request, e.getErrors());
            setHolder(request, new CreateAccountBookHolder(memberList, form, findreadAuthList.getMemberList(), findwriteAuthList.getMemberList()));
            return INPUT;
        }
        setForm(session, form);
        setHolder(request, new CreateAccountBookHolder(form, findreadAuthList.getMemberList(), findwriteAuthList.getMemberList()));
        return CONFIRM;
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

        CreateAccountBookForm form = getForm(session, CreateAccountBookForm.class);
        CreateAccountBook logic = getService().getCreateAccountBook();
        try {
            setAllParameters(logic, form);
            logic.excute();
        } catch (AppException e) {
            setForm(session, form);
//            setHolder(request, new CreateAccountHolder(findMembers.getMemberList(), form));
            removeForm(session, CreateAccountBookForm.class);
            return CONFIRM;
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

    private List<MemberDTO> getMemberListExceptLoginedMember() {
        // 로그인 정보
        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);

        // 본인 이외의 회원 리스트
        FindAllMemberExceptMyself findMemberList = getService().getFindAllMemberExceptMyself();
        findMemberList.setMemberIdx(loginInfo.getMemberIdx());
        findMemberList.excute();

        return findMemberList.getMemberList();
    }

    private void setAllParameters(CreateAccountBook logic, CreateAccountBookForm form) {
        logic.setAccountBookNameKr(form.getAccountBookNameKr());
        logic.setAccountBookNameJp(form.getAccountBookNameJp());
        logic.setCurrency(form.getCurrency());
        logic.setReadAuthList(form.getReadAuthList());
        logic.setWriteAuthList(form.getWriteAuthList());
    }
}
