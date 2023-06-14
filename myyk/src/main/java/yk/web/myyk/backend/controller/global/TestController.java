package yk.web.myyk.backend.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;

@Controller
@RequestMapping("/test")
@CategorySetter(Category.TEST)
public class TestController {
	
	@RequestMapping("/signupMailTest")
	public String signupMailTest() {
		return "test/signupMailTest";
	}
	
}
