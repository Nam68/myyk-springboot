package yk.web.myyk.backend.api.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.form.category.CreateSubCategoryForm;
import yk.web.myyk.backend.dto.form.category.DeleteSubCategoryForm;
import yk.web.myyk.backend.dto.form.category.FindSubCategoryForm;
import yk.web.myyk.backend.dto.form.category.UpdateSubCategoryForm;
import yk.web.myyk.backend.dto.holder.category.UpdateSubCategoryApiHolder;
import yk.web.myyk.backend.service.category.CreateSubCategory;
import yk.web.myyk.backend.service.category.CreateSubCategoryCardHtml;
import yk.web.myyk.backend.service.category.DeleteSubCategory;
import yk.web.myyk.backend.service.category.FindSubCategory;
import yk.web.myyk.backend.service.category.SearchSubCategoryByCategory;
import yk.web.myyk.backend.service.category.UpdateSubCategory;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.AppException;

@RestController
@RequestMapping(path = "/category", method = RequestMethod.POST)
public class CategoryApi extends BaseApi {

    /**
     * <p>서브 카테고리를 생성한다.</p>
     *
     * @param form 폼
     * @return JSON
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/create")
    public Map<String, Object> createSubCategory(CreateSubCategoryForm form) throws ApiException {

        Map<String, Object> json = new HashMap<>();

        CreateSubCategory logic = getService().getCreateSubCategory();
        try {
            logic.setCategoryIdx(form.getCategoryIdx());
            logic.setSubCategoryNameKo(form.getSubCategoryNameKo());
            logic.setSubCategoryNameJp(form.getSubCategoryNameJp());
            logic.excute();

            json = getJson(logic.getSubCategory());

        } catch (AppException e) {
            json = getErrorJson(e.getErrors());
        }
        return json;
    }

    /**
     * <p>서브 카테고리를 갱신한다.</p>
     *
     * @param form 폼
     * @return JSON
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/update")
    public UpdateSubCategoryApiHolder updateSubCategory(UpdateSubCategoryForm form) throws ApiException {

        UpdateSubCategoryApiHolder holder = new UpdateSubCategoryApiHolder();

        UpdateSubCategory logic = getService().getUpdateSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.setSubCategoryNameKo(form.getSubCategoryNameKo());
            logic.setSubCategoryNameJp(form.getSubCategoryNameJp());
            logic.excute();

            SubCategoryDTO dto = logic.getSubCategory();
            holder.setSubCategoryNameKo(dto.getSubCategoryNameKo());
            holder.setSubCategoryNameJp(dto.getSubCategoryNameJp());

        } catch (AppException e) {
            holder.setErrorCodes(e.getErrors());
        }
        return holder;
    }

    /**
     * <p>서브 카테고리를 삭제한다.</p>
     *
     * @param form 폼
     * @return JSON
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/delete")
    public Map<String, Object> deleteSubCategory(DeleteSubCategoryForm form) throws ApiException {

        Map<String, Object> json = new HashMap<>();

        DeleteSubCategory logic = getService().getDeleteSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.excute();

            json = success();

        } catch (AppException e) {
            json = getErrorJson(e.getErrors());
        }
        return json;
    }

    /**
     * <p>서브 카테고리를 검색한다.</p>
     *
     * @param form 폼
     * @return JSON
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/find")
    public Map<String, Object> findSubCategory(FindSubCategoryForm form) throws ApiException {

        Map<String, Object> json = new HashMap<>();

        FindSubCategory logic = getService().getFindSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.excute();

            json = getJson(logic.getSubCategory());

        } catch (AppException e) {
            json = getErrorJson(e.getErrors());
        }
        return json;
    }

    /**
     * <p>서브 카테고리 카드 리스트 HTML을 생성한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     * @return HTML
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/search/card")
    public Map<String, Object> createSubCategoryCardList(long categoryIdx) throws ApiException {

        Map<String, Object> json = new HashMap<>();

        CreateSubCategoryCardHtml logic = getService().getCreateSubCategoryCardHtml();
        SearchSubCategoryByCategory searchSubCategory = getService().getSearchSubCategoryByCategory();
        try {
            searchSubCategory.setCategoryIdx(categoryIdx);
            searchSubCategory.excute();
            List<SubCategoryDTO> subCategoryList = searchSubCategory.getSubCategoryList();

            logic.setSubCategoryList(subCategoryList);
            logic.excute();
            json = getHtml(logic.getHtml());

        } catch (AppException e) {
            json = getErrorJson(e.getErrors());
        }
        return json;
    }
}
