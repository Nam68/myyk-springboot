package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.enumerated.MemberType;

@Controller
@CategorySetter(Category.ACCOUNT)
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account")
public class AccountController {
	
	
	
}
