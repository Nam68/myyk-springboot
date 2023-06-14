package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/member")
@CategorySetter(Category.MEMBER)
public class MemberController extends BaseController {
	
	@RequestMapping("/createInput")
	public String createInput() throws SystemException {
		return "member/createMemberInput";
	}
	
}
