package yk.web.myyk.backend.logic.category;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.FindSubCategory;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindSubCategoryLogic extends BaseLogic implements FindSubCategory {

    private long subCategoryIdx;

    private SubCategoryDTO subCategory;

    @Override
    public void setSubCategoryIdx(long subCategoryIdx) {
        this.subCategoryIdx = subCategoryIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {
        if (!getRepository().getSubCategory().existsById(subCategoryIdx)) {
            throw new AppException(ErrorCode.EE_SC_101);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();
        SubCategoryEntity entity = getRepository().getSubCategory().findById(subCategoryIdx).get();
        subCategory = new SubCategoryDTO(entity);
    }

    @Override
    public SubCategoryDTO getSubCategory() {
        return subCategory;
    }

}
