package yk.web.myyk.backend.logic.category;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.UpdateSubCategory;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UpdateSubCategoryLogic extends BaseLogic implements UpdateSubCategory {

    private long subCategoryIdx;

    private String subCategoryNameKr;

    private String subCategoryNameJp;

    private SubCategoryDTO subCategory;

    @Override
    public void setSubCategoryIdx(long subCategoryIdx) {
        this.subCategoryIdx = subCategoryIdx;
    }

    @Override
    public void setSubCategoryNameKr(String subCategoryNameKr) {
        this.subCategoryNameKr = subCategoryNameKr;
    }

    @Override
    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
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
        entity.setSubCategoryNameKr(subCategoryNameKr);
        entity.setSubCategoryNameJp(subCategoryNameJp);

        update(entity);

        this.subCategory = new SubCategoryDTO(entity);
    }

    @Transactional
    private void update(SubCategoryEntity entity) {
        getRepository().getSubCategory().saveAndFlush(entity);
    }

    @Override
    public SubCategoryDTO getSubCategory() {
        return subCategory;
    }

}
