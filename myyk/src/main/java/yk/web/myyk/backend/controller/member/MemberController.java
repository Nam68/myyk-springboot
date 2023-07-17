package yk.web.myyk.backend.controller.member;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.annotation.RegionSetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/member")
@CategorySetter(Category.MEMBER)
public class MemberController extends BaseController {
	
	/**
	 * <p>회원가입용 인풋 화면.</p>
	 * 
	 * @param email 이메일
	 * @param request 리퀘스트
	 * @return 회원 정보 입력 화면
	 * @throws SystemException 시스템 예외
	 */
	@RequestMapping(path = "/createInput", method = RequestMethod.POST)
	@RegionSetter
	public String createInput(String tmpCode, HttpServletRequest request) throws SystemException {
		String email = getService().getMember().findMailWithTmpCode(tmpCode);
		request.setAttribute("email", email);
		return "member/createMemberInput";
	}
	
	/**
	 * <p>회원가입을 확인하는 화면.</p>
	 * 
	 * @param dto 회원DTO.
	 * @param session 세션
	 * @param request 리퀘스트
	 * @return 회원가입 확인화면
	 * @throws SystemException 시스템 예외
	 */
	@RequestMapping(path = "/createConfirm", method = RequestMethod.POST)
	@RegionSetter
	public String createConfirm(MemberDTO dto, HttpSession session, HttpServletRequest request) throws SystemException {
		Map<String, String> errors = getService().getMember().createVaildate(dto);
		if (!errors.isEmpty()) {
			request.setAttribute("email", dto.getEmail());
			request.setAttribute(ERRORS, errors);
			return "member/createMemberInput";
		}
		session.setAttribute("member", dto); // 회원가입에 이용함, 비밀번호 등을 뷰로 가져가지 않기 위해.
		request.setAttribute("dto", new MemberDTO(dto.getEmail(), dto.getNickname(), dto.getRegion()));
		return "member/createMemberConfirm";
	}
	
	/**
	 * <p>회원가입을 진행하는 컨트롤러.</p>
	 * 
	 * @param session 세션
	 * @return 가입에 성공하면 일단은 홈페이지로 이동
	 * @throws SystemException 시스템 예외
	 */
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String create(HttpSession session) throws SystemException {
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		getService().getMember().create(dto);
		return "redirect:/";
	}
	
}
