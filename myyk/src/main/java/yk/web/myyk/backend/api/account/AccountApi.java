package yk.web.myyk.backend.api.account;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.form.account.CreateSubCategoryForm;
import yk.web.myyk.backend.dto.form.account.DeleteSubCategoryForm;
import yk.web.myyk.backend.service.account.CreateSubCategory;
import yk.web.myyk.backend.service.account.CreateSubCategoryCardHtml;
import yk.web.myyk.backend.service.account.DeleteSubCategory;
import yk.web.myyk.backend.service.account.FindSubCategory;
import yk.web.myyk.backend.service.account.SearchSubCategoryByCategory;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping(path = "/account", method = RequestMethod.POST)
public class AccountApi extends BaseApi {

    /**
     * <p>회계를 등록한다.</p>
     *
     * @param dto 회계DTO
     * @return 성공여부
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/create")
    public String createAccount(AccountDTO dto) throws ApiException {
        try {
//          getService().getAccount().createAccount(dto);
        } catch (SystemException e) {
            throw new ApiException(e.getMessage());
        }
        return Error.SUCCESS.getValue();
    }

    /**
     * <p>서브 카테고리를 생성한다.</p>
     *
     * @param form 폼
     * @return JSON
     * @throws ApiException API예외
     */
    @RequestMapping("/category/sub/create")
    public String createSubCategory(CreateSubCategoryForm form) throws ApiException {
        String json = "";
        CreateSubCategory logic = getService().getCreateSubCategory();
        try {
            logic.setCategoryIdx(form.getCategoryIdx());
            logic.setSubCategoryNameKo(form.getSubCategoryNameKo());
            logic.setSubCategoryNameJp(form.getSubCategoryNameJp());
            logic.excute();

            Gson gson = new Gson();
            json = gson.toJson(logic.getSubCategory());

        } catch (AppException e) {
            json = getErrorJson(e.getErrors());
        }
        return json;
    }

    /**
     * <p>서브 카테고리를 삭제한다.</p>
     *
     * @param form 폼
     * @return JSON
     * @throws ApiException API예외
     */
    @RequestMapping("/category/sub/delete")
    public String deleteSubCategory(DeleteSubCategoryForm form) throws ApiException {
        String json = "";
        DeleteSubCategory logic = getService().getDeleteSubCategory();
        try {
            logic.setSubCategoryIdx(form.getSubCategoryIdx());
            logic.excute();

            json = Error.SUCCESS.name();

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
    @RequestMapping("/category/sub/search/card")
    public String createSubCategoryCardList(long categoryIdx) throws ApiException {
        String html = "";

        CreateSubCategoryCardHtml logic = getService().getCreateSubCategoryCardHtml();
        SearchSubCategoryByCategory searchSubCategory = getService().getSearchSubCategoryByCategory();
        try {
            searchSubCategory.setCategoryIdx(categoryIdx);
            searchSubCategory.excute();
            List<SubCategoryDTO> subCategoryList = searchSubCategory.getSubCategoryList();

            logic.setSubCategoryList(subCategoryList);
            logic.excute();
            html = logic.getHtml();

        } catch (AppException e) {
            html = getErrorJson(e.getErrors());
        }
        return html;
    }
}
