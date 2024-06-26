package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.entity.account.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.SearchSubCategoryByCategory;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SearchSubCategoryByCategoryLogic extends BaseLogic implements SearchSubCategoryByCategory {

    private long categoryIdx;

    private List<SubCategoryDTO> subCategoryList;

    @Override
    public void setCategoryIdx(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Optional<CategoryEntity> categoryEntity = getRepository().getCategory().findById(categoryIdx);

        if (!categoryEntity.isPresent()) {
            throw new AppException(ErrorCode.CG_101);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<SubCategoryEntity> subCategoryEntityList = getRepository().getSubCategory().findAllByCategoryCategoryIdx(categoryIdx, SortUtil.getSortNoAsc());

        List<SubCategoryDTO> subCategoryList = new ArrayList<>();
        for (SubCategoryEntity subCategoryEntity : subCategoryEntityList) {
            subCategoryList.add(new SubCategoryDTO(subCategoryEntity));
        }

        this.subCategoryList = subCategoryList;
    }

    @Override
    public List<SubCategoryDTO> getSubCategoryList() {
        return subCategoryList;
    }
}
