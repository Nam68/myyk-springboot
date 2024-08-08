package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.dto.holder.member.EmailHolder;
import yk.web.myyk.backend.dto.holder.member.TmpCodeHolder;
import yk.web.myyk.backend.service.member.CreateTmpMember;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>임시회원 코드 생성 컨트롤러.</p>
 */
@Controller
@RequestMapping("/member/tmp/code/create")
public class CreateTmpMemberCodeController extends BaseController {

    private static final String INPUT = "member/createTmpMemberCodeInput";
    private static final String CONFIRM = "member/createTmpMemberCodeConfirm";
//    private static final String COMPLETE_REDIRECT = "redirect:/member/tmp/code/create/complete";
//    private static final String COMPLETE = "member/createTmpMemberCodeComplete";

    /**
     * <p>임시회원 코드 생성 입력화면.</p>
     *
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input")
    public String input(HttpServletRequest request) throws SystemException {
        setHolder(request, new EmailHolder());
        return INPUT;
    }

    /**
     * <p>임시회원 코드 생성 입력확인화면.</p>
     *
     * @param emailForm 이메일 정보
     * @param session 세션
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    public String confirm(EmailForm emailForm, HttpSession session, HttpServletRequest request) throws SystemException {

        CreateTmpMember logic = getService().getCreateTmpMember();
        try {
            logic.setEmailLocalpart(emailForm.getEmailLocalpart());
            logic.setEmailDomain(emailForm.getEmailDomain());
            logic.validate();
        } catch (AppException e) {
            setHolder(request, new EmailHolder(emailForm));
            setErrors(request, e.getErrors());
            return INPUT;
        }
        setHolder(request, new EmailHolder(emailForm));
        setForm(session, emailForm);
        return CONFIRM;
    }

    /**
     * <p>임시회원 코드 등록.</p>
     *
     * @param session 세션
     * @return 리다이렉트
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/execute", method = RequestMethod.POST)
    @DataCheck(target = EmailForm.class)
    public String execute(HttpSession session, HttpServletRequest request) throws SystemException {

        EmailForm emailForm = getForm(session, EmailForm.class);
        CreateTmpMember logic = getService().getCreateTmpMember();
        logic.setEmailLocalpart(emailForm.getEmailLocalpart());
        logic.setEmailDomain(emailForm.getEmailDomain());
        logic.excute();

        // 지금은 임시회원코드 입력화면에 임시회원코드를 넣기 위해서 홀더를 사용 중.
        // 원래는 이메일 홀더응 이용해 임시회원 생성 완료 화면으로 전환해야 함.
        setHolder(request, new TmpCodeHolder(logic.getTmpCode()));
        return "member/checkTmpMemberCodeInput";
//      getService().getEmail().sendTmpMemberCode(emailForm, tmpCode);
//      return COMPLETE_REDIRECT;
    }

    /**
     * <p>임시회원 코드 완료화면.</p>
     *
     * @param session 세션
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/complete", method = RequestMethod.POST)
    @DataCheck(target = EmailForm.class)
    @SessionClear
    public String complete(HttpSession session) throws SystemException {
        // 원래는 임시회원코드 입력화면이 아니라, 그냥 완료 메시지만 보여주는 화면으로 전환해야 함.
        // 아직 이메일 기능이 없어서 임시로 입력화면으로 전환.
        return "member/checkTmpMemberCodeInput";
//        return COMPLETE;
    }

}
