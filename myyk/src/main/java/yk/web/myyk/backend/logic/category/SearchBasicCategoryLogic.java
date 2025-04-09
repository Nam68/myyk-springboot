package yk.web.myyk.backend.logic.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.factory.QueryBuilder;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.SearchBasicCategory;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SearchBasicCategoryLogic extends BaseLogic implements SearchBasicCategory {

    private List<CategoryEntity> entityList;

    private List<CategoryDTO> categoryList;

    @Override
    public void validate() throws SystemException, AppException {

        QueryBuilder qb = QueryBuilder.getQueryBuilder(getEm())
                .setFrom("cat", CategoryEntity.class)
                .where("cat.basic = :basic")
                .notDeleted()
                .setParameter("basic", true)
                .createQuery();
        List<CategoryEntity> categoryList = qb.getResult();
        this.entityList = categoryList;
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<CategoryDTO> categoryList = new ArrayList<>();

        for (CategoryEntity entity : entityList) {

            // 서브 카테고리 리스트 취득
            List<SubCategoryDTO> subCategoryList = getSubCategoryList(entity);

            // 카테고리DTO 생성
            CategoryDTO dto = new CategoryDTO(entity);
            dto.setSubCategoryList(subCategoryList);

            // 카테고리DTO에 세팅
            categoryList.add(dto);
        }

        this.categoryList = categoryList;
    }

    @Override
    public List<CategoryDTO> getBasicCategory() {
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
