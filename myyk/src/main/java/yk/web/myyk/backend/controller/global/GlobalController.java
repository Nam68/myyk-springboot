package yk.web.myyk.backend.controller.global;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.config.AppConstants;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;

@Controller
@CategorySetter(Category.HOME)
public class GlobalController extends BaseController {
	
	@RequestMapping({"/", "/global/homepage"})
	public String homepage() {
		return "global/homepage";
	}

}