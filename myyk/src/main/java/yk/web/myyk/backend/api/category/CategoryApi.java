package yk.web.myyk.backend.api.category;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.form.category.CreateSubCategoryForm;
import yk.web.myyk.backend.dto.form.category.DeleteSubCategoryForm;
import yk.web.myyk.backend.dto.form.category.FindSubCategoryForm;
import yk.web.myyk.backend.dto.form.category.UpdateSubCategoryForm;
import yk.web.myyk.backend.dto.holder.BaseApiHolder;
import yk.web.myyk.backend.dto.holder.HtmlHolder;
import yk.web.myyk.backend.dto.holder.category.FindSubCategoryApiHolder;
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
     * @return API홀더
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/create")
    public BaseApiHolder createSubCategory(CreateSubCategoryForm form) throws ApiException {

        BaseApiHolder holder = new BaseApiHolder();

        CreateSubCategory logic = getService().getCreateSubCategory();
        try {
            logic.setCategoryIdx(form.getCategoryIdx());
            logic.setSubCategoryNameKo(form.getSubCategoryNameKo());
            logic.setSubCategoryNameJp(form.getSubCategoryNameJp());
            logic.excute();
        } catch (AppException e) {
            holder.setErrorCodes(e.getErrors());
        }
        return holder;
    }

    /**
     * <p>서브 카테고리를 갱신한다.</p>
     *
     * @param form 폼
     * @return API홀더
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/update")
    public BaseApiHolder updateSubCategory(UpdateSubCategoryForm form) throws ApiException {

        BaseApiHolder holder = new BaseApiHolder();

        UpdateSubCategory logic = getService().getUpdateSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.setSubCategoryNameKo(form.getSubCategoryNameKo());
            logic.setSubCategoryNameJp(form.getSubCategoryNameJp());
            logic.excute();
        } catch (AppException e) {
            holder.setErrorCodes(e.getErrors());
        }
        return holder;
    }

    /**
     * <p>서브 카테고리를 삭제한다.</p>
     *
     * @param form 폼
     * @return API홀더
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/delete")
    public BaseApiHolder deleteSubCategory(DeleteSubCategoryForm form) throws ApiException {

        BaseApiHolder holder = new BaseApiHolder();

        DeleteSubCategory logic = getService().getDeleteSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.excute();
        } catch (AppException e) {
            holder.setErrorCodes(e.getErrors());
        }
        return holder;
    }

    /**
     * <p>서브 카테고리를 검색한다.</p>
     *
     * @param form 폼
     * @return API홀더
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/find")
    public FindSubCategoryApiHolder findSubCategory(FindSubCategoryForm form) throws ApiException {

        FindSubCategoryApiHolder holder = new FindSubCategoryApiHolder();

        FindSubCategory logic = getService().getFindSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.excute();

            SubCategoryDTO dto = logic.getSubCategory();
            holder.setCategoryIdx(dto.getCategoryIdx());
            holder.setSubCategoryNameKo(dto.getSubCategoryNameKo());
            holder.setSubCategoryNameJp(dto.getSubCategoryNameJp());

        } catch (AppException e) {
            holder.setErrorCodes(e.getErrors());
        }
        return holder;
    }

    /**
     * <p>서브 카테고리 카드 리스트 HTML을 생성한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     * @return API홀더
     * @throws ApiException API예외
     */
    @RequestMapping("/sub/search/card")
    public HtmlHolder createSubCategoryCardList(long categoryIdx) throws ApiException {

        HtmlHolder holder = new HtmlHolder();

        CreateSubCategoryCardHtml logic = getService().getCreateSubCategoryCardHtml();
        SearchSubCategoryByCategory searchSubCategory = getService().getSearchSubCategoryByCategory();
        try {
            searchSubCategory.setCategoryIdx(categoryIdx);
            searchSubCategory.excute();
            List<SubCategoryDTO> subCategoryList = searchSubCategory.getSubCategoryList();

            logic.setSubCategoryList(subCategoryList);
            logic.excute();
            holder.setHtml(logic.getHtml());

        } catch (AppException e) {
            holder.setErrorCodes(e.getErrors());
        }
        return holder;
    }
}
