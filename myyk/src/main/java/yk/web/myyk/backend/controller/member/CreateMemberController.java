package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.form.member.TmpCodeForm;
import yk.web.myyk.backend.dto.holder.member.CreateMemberHolder;
import yk.web.myyk.backend.dto.holder.member.EmailHolder;
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
        String email = getService().getMember().getEmailByTmpCode(form);

        CreateMemberHolder holder = new CreateMemberHolder();
        holder.setEmailLocalpart(getEmailLocalpart(email));
        holder.setEmailDomain(getEmailDomain(email));
        request.setAttribute(HOLDER, holder);

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
    public String confirm(MemberForm form, HttpSession session, HttpServletRequest request) throws SystemException {
        try {
            getService().getMember().checkMember(form);
            request.setAttribute(HOLDER, form);
            return "member/createMemberConfirm";
        } catch (AppException e) {
            request.setAttribute(ERRORS, new CreateMemberHolder(form));
            return "member/createMemberInput";
        }
    }

}
