package yk.web.myyk.backend.controller.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookForm;
import yk.web.myyk.backend.dto.holder.account.CreateAccountBookHolder;
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
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/book/create")
public class CreateAccountBookController extends BaseController {

    private static final String INPUT = "account/book/createAccountBookInput";
    private static final String CONFIRM = "account/book/createAccountBookConfirm";
    private static final String COMPLETE = "account/book/createAccountBookComplete";
    private static final String COMPLETE_REDIRECT = "redirect:/account/book/create/complete";

    /**
     * <p>가계부 정보 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input")
    @SetEnum(target = {Currency.class})
    public String input(HttpServletRequest request) throws SystemException {

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

        FindAllMemberByIdx findMemberList = getService().getFindAllMemberByIdx();
        CreateAccountBook logic = getService().getCreateBook();
        try {
            findMemberList.setMemberIdxList(form.getReadAuthList());
            findMemberList.validate();

            findMemberList.setMemberIdxList(form.getWriteAuthList());
            findMemberList.validate();

            setAllParameters(logic, form);
            logic.validate();
        } catch (AppException e) {
            // 본인 이외의 회원 리스트
            List<MemberDTO> memberList = getMemberListExceptLoginedMember();
            setErrors(request, e.getErrors());
            setHolder(request, new CreateAccountBookHolder(memberList, form));
            return INPUT;
        }
        CreateAccountBookHolder holder = getHolder(form);
        setForm(session, form);
        setHolder(request, holder);
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
        CreateAccountBook logic = getService().getCreateBook();
        try {
            setAllParameters(logic, form);
            logic.excute();

            // 인덱스 DTO 전달
            setDTO(session, logic.getAccountBook());

        } catch (AppException e) {
            CreateAccountBookHolder holder = getHolder(form);
            setErrors(request, e.getErrors());
            setHolder(request, holder);
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
    @RequestMapping(path = "/complete")
    @DataCheck(target = AccountBookDTO.class)
    @SessionClear
    public String complete(HttpSession session, HttpServletRequest request) throws SystemException {
        AccountBookDTO dto = getDTO(session, AccountBookDTO.class);
        CreateAccountBookHolder holder = new CreateAccountBookHolder(dto.getAccountBookIdx());
        setHolder(request, holder);
        return COMPLETE;
    }

    /**
     * <p>본인 이외의 회원 리스트를 반환한다.</p>
     *
     * @return 본인 이외의 회원 리스트
     */
    private List<MemberDTO> getMemberListExceptLoginedMember() {
        // 로그인 정보
        LoginInfo loginInfo = getLoginInfo(CreateAccountBookController.class);

        // 본인 이외의 회원 리스트
        FindAllMemberExceptMyself findMemberList = getService().getFindAllMemberExceptMyself();
        findMemberList.setMemberIdx(loginInfo.getMemberIdx());
        findMemberList.excute();

        return findMemberList.getMemberList();
    }

    /**
     * <p>홀더를 반환한다.</p>
     *
     * @param form {@link CreateAccountBookForm}
     * @return {@link CreateAccountBookHolder}
     */
    private CreateAccountBookHolder getHolder(CreateAccountBookForm form) {

        List<MemberDTO> readAuthList = new ArrayList<>();
        List<MemberDTO> writeAuthList = new ArrayList<>();

        FindAllMemberByIdx findMemberList = getService().getFindAllMemberByIdx();
        findMemberList.setMemberIdxList(form.getReadAuthList());
        findMemberList.excute();
        readAuthList = findMemberList.getMemberList();

        findMemberList.setMemberIdxList(form.getWriteAuthList());
        findMemberList.excute();
        writeAuthList = findMemberList.getMemberList();

        CreateAccountBookHolder holder = new CreateAccountBookHolder(form, readAuthList, writeAuthList);
        return holder;
    }

    /**
     * <p>로직에 폼의 모든 값을 설정한다.</p>
     *
     * @param logic {@link CreateAccountBook}
     * @param form {@link CreateAccountBookForm}
     */
    private void setAllParameters(CreateAccountBook logic, CreateAccountBookForm form) {
        logic.setAccountBookNameKr(form.getAccountBookNameKr());
        logic.setAccountBookNameJp(form.getAccountBookNameJp());
        logic.setCurrency(form.getCurrency());
        logic.setReadAuthList(form.getReadAuthList());
        logic.setWriteAuthList(form.getWriteAuthList());
    }
}
