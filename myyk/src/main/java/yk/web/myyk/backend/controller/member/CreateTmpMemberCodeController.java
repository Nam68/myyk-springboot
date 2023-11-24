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
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.exception.AppException;
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
        request.setAttribute(HOLDER, new EmailHolder());
        return "member/createTmpMemberCodeInput";
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
        try {
            getService().getMember().checkTmpMember(emailForm);
        } catch (AppException e) {
            request.setAttribute(HOLDER, emailForm);
            request.setAttribute(ERRORS, e.getErrors());
            return "/member/createTmpMemberCodeInput";
        }
        request.setAttribute(HOLDER, new EmailHolder(emailForm));
        setForm(session, emailForm);
        return "member/createTmpMemberCodeConfirm";
    }

    /**
     * <p>임시회원 코드 등록.</p>
     * 
     * @param session 세션
     * @return 리다이렉트
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/execute", method = RequestMethod.POST)
    @DataCheck(target = {EmailForm.class})
    public String execute(HttpSession session, HttpServletRequest request) throws SystemException {

        EmailForm emailForm = getForm(session, EmailForm.class);
        String tmpCode = getService().getMember().createTmpMember(emailForm);
        request.setAttribute(HOLDER, new TmpCodeHolder(emailForm.getEmailLocalpart(), emailForm.getEmailDomain(), tmpCode));
        removeAllForm(session);
        return "member/checkTmpMemberCodeInput";
//      getService().getEmail().sendTmpMemberCode(emailForm, tmpCode);
//      return "redirect:/member/tmp/code/create/complete";
    }

    /**
     * <p>임시회원 코드 완료화면.</p>
     * 
     * @param session 세션
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/complete", method = RequestMethod.POST)
    public String complete(HttpSession session) throws SystemException {
        removeAllForm(session);
        return "member/checkTmpMemberCodeInput";
    }

}
