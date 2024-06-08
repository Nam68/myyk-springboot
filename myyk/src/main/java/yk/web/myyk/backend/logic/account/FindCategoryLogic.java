package yk.web.myyk.backend.logic.account;

import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.FindCategory;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindCategoryLogic extends BaseLogic implements FindCategory {

    private long categoryIdx;

    private CategoryDTO category;

    @Override
    public void setCategoryIdx(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {
        Optional<CategoryEntity> categoryOptional = getRepository().getCategory().findById(categoryIdx);
        if (!categoryOptional.isPresent()) {
            throw new AppException(ErrorCode.CG_101);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        CategoryEntity categoryEntity = getRepository().getCategory().findById(categoryIdx).get();

        this.category = new CategoryDTO(categoryEntity);
    }

    @Override
    public CategoryDTO getCategory() {
        return category;
    }

}
