package yk.web.myyk.backend.controller.language;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.HOME)
@RequestMapping("/language")
public class LanguageController extends BaseController {

	@RequestMapping("/setting")
	public String setting() throws SystemException {
		return "language/setting";
	}
	
}
