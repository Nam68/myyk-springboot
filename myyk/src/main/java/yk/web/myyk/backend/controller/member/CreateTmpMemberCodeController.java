package yk.web.myyk.backend.controller.member;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.checker.MemberChecker;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>임시회원 코드 생성 컨트롤러.</p>
 */
@Controller
@RequestMapping("/member/tmp/code/create")
public class CreateTmpMemberCodeController extends BaseController {

    /**
     * <p>임시회원 코드 생성 입력화면.</p>
     * 
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/input")
    public String input(HttpServletRequest request) throws SystemException {
        request.setAttribute(HOLDER, new EmailForm());
        return "/member/createTmpMemberCodeInput";
    }

    /**
     * <p>임시회원 코드 생성 입력확인.</p>
     * 
     * @param emailForm 이메일 정보
     * @param session 세션
     * @param request 리퀘스트
     * @return 실행 리다이렉트
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/confirm")
    public String confirm(EmailForm emailForm, HttpSession session, HttpServletRequest request) throws SystemException {
        Map<String, ErrorCode> errors = MemberChecker.checkEmail(emailForm.getEmailLocalpart(), emailForm.getEmailDomain());
        if (!errors.isEmpty()) {
            request.setAttribute(HOLDER, emailForm);
            request.setAttribute(ERRORS, errors);
            return "/member/createTmpMemberCodeInput";
        }
        setForm(session, emailForm);
        return "redirect:/member/tmp/code/create/execute";
    }

    @RequestMapping("/execute")
    @DataCheck(target = {EmailForm.class})
    public String execute() throws SystemException {
        return "redirect:/member/tmp/code/create/complete";
    }

    @RequestMapping("/complete")
    public String complete() throws SystemException {
        return "member/checkTmpMemberCodeInput";
    }

}
