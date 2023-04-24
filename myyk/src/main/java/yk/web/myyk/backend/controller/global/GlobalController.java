package yk.web.myyk.backend.controller.global;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;

@Controller
public class GlobalController extends BaseController {
	
	@RequestMapping({"/", "/global/homepage"})
	public String homepage(HttpServletRequest request) {
		
		request.setAttribute("category", "MEMBER");
		
		return "global/homepage";
	}

}