package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.CreateAccountBookCategory;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateAccountBookCategoryLogic extends BaseLogic implements CreateAccountBookCategory {

    private long accountBookIdx;

    private List<Long> categoryIdxList;

    private List<Long> subCategoryIdxList;

    private List<CategoryDTO> categoryList;

    private List<SubCategoryDTO> subCategoryList;

    private AccountBookDTO accountBook;

    @Override
    public void setAccountBookIdx(long accountBookIdx) {
        this.accountBookIdx = accountBookIdx;
    }

    @Override
    public void setCategoryIdxList(List<Long> categoryIdxList) {
        this.categoryIdxList = categoryIdxList;
    }

    @Override
    public void setSubCategoryIdxList(List<Long> subCategoryIdxList) {
        this.subCategoryIdxList = subCategoryIdxList;
    }

    @Override
    public void validate() throws SystemException, AppException {

        // 가계부 존재체크
        if (!getRepository().getAccountBook().existsById(accountBookIdx)) {
            throw new AppException(ErrorCode.AB_101);
        }

        // 카테고리 존재체크
        List<CategoryEntity> categoryEntityList = getRepository().getCategory().findAllById(categoryIdxList);
        if (categoryEntityList.isEmpty()) {
            throw new AppException(ErrorCode.CG_101);
        }

        // 서브 카테고리 중 카테고리가 선택되지 않은 경우 에러
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        // 가계부 습득
        AccountBookEntity accountBookEntity = getRepository().getAccountBook().findById(accountBookIdx).get();

        // 카테고리 습득
        List<CategoryEntity> categoryEntityList = getRepository().getCategory().findAllById(categoryIdxList);
        List<SubCategoryEntity> subCategoryEntityList = getRepository().getSubCategory().findAllById(subCategoryIdxList);

        // 가계부에 카테고리 설정
        accountBookEntity.setCategoryList(categoryEntityList);
        accountBookEntity.setSubCategoryList(subCategoryEntityList);
        update(accountBookEntity);

        // 반환용 DTO
        List<CategoryDTO> categoryList = new ArrayList<>();
        List<SubCategoryDTO> subCategoryList = new ArrayList<>();

        // DTO에 엔티티를 설정
        for (CategoryEntity categoryEntity : categoryEntityList) {
            CategoryDTO category = new CategoryDTO(categoryEntity);
            categoryList.add(category);
        }
        for (SubCategoryEntity subCategoryEntity : subCategoryEntityList) {
            SubCategoryDTO subCategory = new SubCategoryDTO(subCategoryEntity);
            subCategoryList.add(subCategory);
        }

        // 반환용 클래스 변수 설정
        this.categoryList = categoryList;
        this.subCategoryList = subCategoryList;
        this.accountBook = new AccountBookDTO(accountBookEntity, categoryList, subCategoryList);
    }

    @Transactional
    private void update(AccountBookEntity accountBookEntity) {
        getRepository().getAccountBook().saveAndFlush(accountBookEntity);
    }

    @Override
    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    @Override
    public List<SubCategoryDTO> getSubCategoryList() {
        return subCategoryList;
    }

    @Override
    public AccountBookDTO getAccountBook() {
        return accountBook;
    }
}
