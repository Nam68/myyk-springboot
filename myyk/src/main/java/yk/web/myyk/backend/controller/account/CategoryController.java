package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
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
	public String search(long accountBookIdx, HttpServletRequest request) throws SystemException {
		List<PrimeCategoryDTO> list = getService().getCategory().getPrimeCategory(accountBookIdx);
		request.setAttribute(LIST, list);
		request.setAttribute(IDX, accountBookIdx);
		return "account/searchCategory";
	}
	
	@RequestMapping("/createInput")
	public String createInput(long accountBookIdx, HttpServletRequest request) throws SystemException {
		request.setAttribute(IDX, accountBookIdx);
		return "account/createCategoryInput";
	}
	
	@RequestMapping(path = "/createPrimeCategory", method = RequestMethod.POST)
	public String createPrimeCateogry(PrimeCategoryDTO dto) throws SystemException {
		getService().getCategory().create(dto);
		// 리스트 화면에 서브카테고리 생성버튼 만들것
		return "";
	}
	
}