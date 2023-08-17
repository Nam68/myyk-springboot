package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.annotation.CategorySetter;
import yk.web.myyk.util.enumerated.Category;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@CategorySetter(Category.ACCOUNT)
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/category")
public class CategoryController extends BaseController {

	@RequestMapping("/search")
	public String search(long accountBookIdx) throws SystemException {
		// 리포지토리, 서비스, 로직 만들고 리스트 얻어오는 것까지
		return "account/searchCategory";
	}
	
	@RequestMapping("/createInput")
	public String createInput() throws SystemException {
		
		return "account/createCategoryInput";
	}
	
}
