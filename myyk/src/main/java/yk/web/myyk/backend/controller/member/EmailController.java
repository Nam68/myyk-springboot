package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;

@Controller
@RequestMapping("/member")
public class EmailController extends BaseController {
	
	@RequestMapping("/emailCheckInput")
	public String input(HttpServletRequest request) {
		request.setAttribute("category", "MEMBER");
		return "member/emailCheckInput";
	}
	
	@RequestMapping("/emailCheckConfirm")
	public String confirm(HttpServletRequest request) {
		request.setAttribute("category", "CALENDAR");
		return "global/homepage";
	}
	
}
