package yk.web.myyk.backend.logic.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.SearchCategoryByMember;
import yk.web.myyk.util.checker.LocaleChecker;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SearchCategoryByMemberLogic extends BaseLogic implements SearchCategoryByMember {

    private boolean needSubCategory;

    private Locale locale;

    private long memberIdx;

    private List<CategoryDTO> categoryList;

    @Override
    public void setNeedSubCategory(boolean needSubCategory) {
        this.needSubCategory = needSubCategory;
    }

    @Override
    public void setMemberIdx(long memberIdx) {
        this.memberIdx = memberIdx;
    }

    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void validate() throws SystemException, AppException {

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

            // 기본 카테고리 || 삭제 카테고리를 제외
            if (entity.isBasic() || entity.isDeleted()) {
                continue;
            }

            // 서브 카테고리 검색
            List<SubCategoryDTO> subCategoryList = new ArrayList<>();
            if (needSubCategory) {
                subCategoryList = getSubCategoryList(entity);
            }

            CategoryDTO dto = new CategoryDTO(entity);
            dto.setSubCategoryList(subCategoryList);
            list.add(dto);
        }
        this.categoryList = list;
    }

    @Override
    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    @Transactional
    public List<SubCategoryDTO> getSubCategoryList(CategoryEntity entity) {

        List<SubCategoryDTO> subCategoryList = new ArrayList<>();

        for (SubCategoryEntity subCategory : entity.getSubCategoryList()) {
            subCategoryList.add(new SubCategoryDTO(subCategory));
        }
        return subCategoryList;
    }

}
