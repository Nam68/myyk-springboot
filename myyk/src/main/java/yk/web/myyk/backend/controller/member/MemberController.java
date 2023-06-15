package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/member")
@CategorySetter(Category.MEMBER)
public class MemberController extends BaseController {
	
	@RequestMapping(path = "/createInput", method = RequestMethod.POST)
	// 지역을 넣어주는 어노테이션 만들기
	public String createInput() throws SystemException {
		return "member/createMemberInput";
	}
	
}
