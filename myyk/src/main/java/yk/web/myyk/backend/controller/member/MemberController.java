package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
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
	
	@RequestMapping(path = "/createInput", method = RequestMethod.POST)
	@RegionSetter
	public String createInput(String email, HttpServletRequest request) throws SystemException {
		request.setAttribute("email", email);
		return "member/createMemberInput";
	}
	
	@RequestMapping(path = "/createConfirm", method = RequestMethod.POST)
	public String createConfirm(MemberDTO dto, HttpServletRequest request) throws SystemException {
		request.setAttribute("dto", dto);
		return "member/createMemberConfirm";
	}
	
}
