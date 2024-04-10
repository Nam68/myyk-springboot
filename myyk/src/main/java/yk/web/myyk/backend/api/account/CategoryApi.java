package yk.web.myyk.backend.api.account;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping(path = "/account/category", method = RequestMethod.POST)
public class CategoryApi extends BaseApi {

//	/**
//	 * <p>서브카테고리를 생성한다.</p>
//	 *
//	 * @param dto 서브카테고리 DTO
//	 * @return 성공여부
//	 * @throws SystemException 시스템에러
//	 */
//	@RequestMapping("/createSubCategory")
//	public String createSubCategory(SubCategoryDTO dto) throws ApiException {
//		return getService().getCategory().create(dto).getValue();
//	}
//
//	/**
//	 * <p>서브카테고리를 반환한다.</p>
//	 *
//	 * @param categoryIdx 카테고리 IDX
//	 * @return 서브카테고리 리스트
//	 * @throws SystemException 시스템에러
//	 */
//	@RequestMapping("/getSubCategoryList")
//	public String getSubCategoryList(long categoryIdx) throws ApiException {
//		List<SubCategoryDTO> list = getService().getCategory().getSubCategory(categoryIdx);
//		return new Gson().toJson(list);
//	}
}
