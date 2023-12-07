package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.MEMBER)
@RequestMapping("/member")
public class EmailController extends BaseController {
	
	/**
	 * <p>이메일 확인용 인풋 화면.</p>
	 * 
	 * @return 이메일 체크용 화면
	 * @throws SystemException 시스템 예외
	 */
	@RequestMapping("/emailCheckInput")
	public String input() throws SystemException {
		return "member/emailCheckInput";
	}
	
	/**
	 * <p>이메일 중복 체크.</p>
	 * 
	 * @param email 체크 대상 이메일
	 * @param request 리퀘스트
	 * @return 검증코드 인증 화면
	 * @throws SystemException 시스템 예외
	 */
//	@RequestMapping(path = "/emailCheckConfirm", method = RequestMethod.POST)
//	public String confirm(String email, HttpServletRequest request) throws SystemException {
//		Map<String, String> errors = getService().getMember().emailValidate(email);
//		if (!errors.isEmpty()) {
//			request.setAttribute(ERRORS, errors);
//			return "member/emailCheckInput";
//		}
//		getService().getEmail().sendEmailConfirm(email);
//		return "member/checkTmpCodeInput";
//	}
	
}
