package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;

@Controller
@CategorySetter(Category.MEMBER)
@RequestMapping("/member")
public class EmailController extends BaseController {
	
	@RequestMapping("/emailCheckInput")
	public String input(HttpServletRequest request) {
		return "member/emailCheckInput";
	}
	
	@RequestMapping("/emailCheckConfirm")
	public String confirm(HttpServletRequest request) {
		return "global/homepage";
	}
	
}
