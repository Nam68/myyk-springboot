package yk.web.myyk.backend.logic.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.SearchCategoryByMember;
import yk.web.myyk.util.checker.LocaleChecker;
import yk.web.myyk.util.constant.MyLocale;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SearchCategoryByMemberLogic extends BaseLogic implements SearchCategoryByMember {

    private Locale locale;

    private long memberIdx;

    private List<CategoryDTO> categoryList;

    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void validate() throws SystemException, AppException {
        LoginInfo loginInfo = getLoginInfo(CreateCategoryLogic.class);
        this.memberIdx = loginInfo.getMemberIdx();

        Map<String, ErrorCode> errors = new HashMap<>();

        errors.putAll(LocaleChecker.checkValidLocale(locale));

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<CategoryEntity> entityList = getRepository().getCategory().findAllByMemberMemberIdx(memberIdx, SortUtil.getSortNoAsc());

        List<CategoryDTO> list = new ArrayList<>();
        for (CategoryEntity entity : entityList) {

            CategoryDTO dto = new CategoryDTO(entity);

            Map<Long, String> subCategoryList = getSubCategoryList(entity, locale);
            dto.setSubCategoryList(subCategoryList);

            list.add(dto);
        }
        this.categoryList = list;
    }

    @Transactional
    public Map<Long, String> getSubCategoryList(CategoryEntity entity, Locale locale) {

        Map<Long, String> subCategoryList = new HashMap<>();

        for (SubCategoryEntity subCategory : entity.getSubCategoryList()) {

            long subCategoryIdx = subCategory.getSubCategoryIdx();
            String subCategoryName = MyLocale.isKorean(locale) ? subCategory.getSubCategoryNameKr() : subCategory.getSubCategoryNameJp();

            subCategoryList.put(subCategoryIdx, subCategoryName);
        }
        return subCategoryList;
    }

    @Override
    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

}
