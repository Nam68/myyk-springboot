package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
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

	/**
	 * <p>카테고리 리스트 페이지로 이동한다.</p>
	 * 
	 * @param accountBookIdx 가계부 인덱스
	 * @param request 리퀘스트
	 * @return 뷰
	 * @throws SystemException 시스템에러
	 */
	@RequestMapping("/list")
	public String list(long accountBookIdx, HttpServletRequest request) throws SystemException {
		List<PrimeCategoryDTO> list = getService().getCategory().getPrimeCategory(accountBookIdx);
//		request.setAttribute(LIST, list);
//		request.setAttribute(IDX, accountBookIdx);
		return "account/listCategory";
	}
	
	/**
	 * <p>1차 카테고리 생성 페이지로 이동한다.</p>
	 * 
	 * @param accountBookIdx 가계부 인덱스
	 * @param request 리퀘스트
	 * @return 뷰
	 * @throws SystemException 시스템에러
	 */
	@RequestMapping("/createInput")
	public String createInput(long accountBookIdx, HttpServletRequest request) throws SystemException {
//		request.setAttribute(IDX, accountBookIdx);
		return "account/createCategoryInput";
	}
	
	/**
	 * <p>1차 카테고리를 생성한다.</p>
	 * 
	 * @param dto 1차 카테고리 DTO
	 * @return 리다이렉트
	 * @throws SystemException 시스템에러
	 */
	@RequestMapping(path = "/createPrimeCategory", method = RequestMethod.POST)
	public String createPrimeCateogry(PrimeCategoryDTO dto) throws SystemException {
		try {
			getService().getCategory().create(dto);
		} catch (SystemException e) {
			return "account/createCategoryInput";
		}
		return "redirect:/account/category/list";
	}
	
}
