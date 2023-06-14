package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.MEMBER)
@RequestMapping("/member")
public class EmailController extends BaseController {
	
	@RequestMapping("/emailCheckInput")
	public String input() throws SystemException {
		return "member/emailCheckInput";
	}
	
	@RequestMapping(path = "/emailCheckConfirm", method = RequestMethod.POST)
	public String confirm(String email) throws SystemException {
		getService().getEmail().sendEmailConfirm(email);
		return "member/checkTmpCodeInput";
	}
	
}
