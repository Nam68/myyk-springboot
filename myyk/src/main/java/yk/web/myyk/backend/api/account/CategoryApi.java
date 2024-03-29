package yk.web.myyk.backend.api.account;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping("/account/category")
public class CategoryApi extends BaseApi {

	/**
	 * <p>서브카테고리를 생성한다.</p>
	 * 
	 * @param dto 서브카테고리 DTO
	 * @return 성공여부
	 * @throws SystemException 시스템에러
	 */
	@RequestMapping(path = "/createSubCategory", method = RequestMethod.POST)
	public String createSubCategory(SubCategoryDTO dto) throws SystemException {
		return getService().getCategory().create(dto).getValue();
	}
}
