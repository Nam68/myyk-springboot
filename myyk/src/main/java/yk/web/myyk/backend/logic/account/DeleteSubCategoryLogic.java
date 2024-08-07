package yk.web.myyk.backend.logic.account;

import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.account.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.DeleteSubCategory;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DeleteSubCategoryLogic extends BaseLogic implements DeleteSubCategory {

    private long subCategoryIdx;

    private SubCategoryEntity subCategoryEntity;

    @Override
    public void setSubCategoryIdx(long subCategoryIdx) {
        this.subCategoryIdx = subCategoryIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {
        Optional<SubCategoryEntity> subCategoryEntity = getRepository().getSubCategory().findById(subCategoryIdx);
        if (!subCategoryEntity.isPresent()) {
            throw new AppException(ErrorCode.EE_SC_101);
        }
        this.subCategoryEntity = subCategoryEntity.get();
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();
        deleteSubCategory(subCategoryEntity);
    }

    @Transactional
    private void deleteSubCategory(SubCategoryEntity subCategoryEntity) {
        getRepository().getSubCategory().delete(subCategoryEntity);
    }

}
