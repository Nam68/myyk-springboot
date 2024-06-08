package yk.web.myyk.backend.controller.account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.holder.account.CreateSubCategoryHolder;
import yk.web.myyk.backend.service.account.FindCategory;
import yk.web.myyk.backend.service.account.SearchSubCategoryByCategory;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/category/sub/create")
public class CreateSubCategoryController extends BaseController {

    private static final String CATEGORY_EDIT_REDIRECT = "redirect:/account/category/edit";
    private static final String INPUT = "account/category/createSubCategoryInput";


    @RequestMapping("/input")
    public String input(long categoryIdx) throws SystemException {

        FindCategory categoryLogic = getService().getFindCategory();
        SearchSubCategoryByCategory subCategoryLogic = getService().getSearchSubCategoryByCategory();
        try {

            // 카테고리 취득
            categoryLogic.setCategoryIdx(categoryIdx);
            categoryLogic.excute();
            CategoryDTO category = categoryLogic.getCategory();

            // 서브 카테고리 리스트 취득
            subCategoryLogic.setCategoryIdx(categoryIdx);
            subCategoryLogic.excute();
            List<SubCategoryDTO> subCategoryList = subCategoryLogic.getSubCategoryList();

            // 세션에 입력된 언어값 취득
            String locale = getCurrentLanguage(CreateSubCategoryController.class);

            new CreateSubCategoryHolder(category, subCategoryList, locale);

        } catch (AppException e) {
            return CATEGORY_EDIT_REDIRECT;
        }

        return INPUT;
    }
}
