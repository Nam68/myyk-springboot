package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.form.member.TmpCodeForm;
import yk.web.myyk.backend.dto.holder.member.CreateMemberHolder;
import yk.web.myyk.backend.dto.holder.member.TmpCodeHolder;
import yk.web.myyk.backend.service.member.FindEmailByTmpCode;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.annotation.SessionClear;
import yk.web.myyk.util.annotation.SetEnum;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>회원 생성 컨트롤러.</p>
 */
@Controller
@RequestMapping("/member/create")
public class CreateMemberController extends BaseController {

    /**
     * <p>회원 생성 입력화면.</p>
     *
     * @param form 임시회원 코드
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/input", method = RequestMethod.POST)
    @SetEnum(target = {Region.class})
    public String input(TmpCodeForm form, HttpServletRequest request) throws SystemException {

        FindEmailByTmpCode logic = getService().getFindEmailByTmpCode();
        try {
            logic.setTmpCode(form.getTmpCode());
            logic.excute();
        } catch (AppException e) {
            // 원래대로면 필요가 없어야하는 코드 [시작]
            setHolder(request, new TmpCodeHolder(EMPTY));
            // 원래대로면 필요가 없어야하는 코드 [끝]
            setErrors(request, e.getErrors());
            return "member/checkTmpMemberCodeInput";
        }
        CreateMemberHolder holder = new CreateMemberHolder();
        holder.setEmailLocalpart(logic.getEmailLocalpart());
        holder.setEmailDomain(logic.getEmailDomain());
        setHolder(request, holder);
        return "member/createMemberInput";
    }

    /**
     * <p>회원 생성 입력확인 화면.</p>
     *
     * @param form 회원 폼
     * @param session 세션
     * @param request 리퀘스트
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/confirm", method = RequestMethod.POST)
    @SetEnum(target = {Region.class})
    public String confirm(MemberForm form, HttpSession session, HttpServletRequest request) throws SystemException {
        try {
            getService().getMember().checkMember(form);
        } catch (AppException e) {
            request.setAttribute(HOLDER, new CreateMemberHolder(form));
            request.setAttribute(ERRORS, e.getErrors());
            return "member/createMemberInput";
        }
        request.setAttribute(HOLDER, form);
        setForm(session, form);
        return "member/createMemberConfirm";
    }

    /**
     * <p>회원 생성.</p>
     *
     * @param session 세션
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/excute", method = RequestMethod.POST)
    @DataCheck(target = MemberForm.class)
    public String execute(HttpSession session) throws SystemException {
        MemberForm form = getForm(session, MemberForm.class);
        getService().getMember().createMember(form);
        return "redirect:/member/create/complete";
    }

    /**
     * <p>회원 생성 후 로그인 화면.</p>
     *
     * @param session 세션
     * @return 뷰 이름
     * @throws SystemException 시스템에러
     */
    @RequestMapping(path = "/complete")
    @DataCheck(target = MemberForm.class)
    @SessionClear
    public String complete(HttpSession session) throws SystemException {
        return "member/createMemberComplete";
    }

}
