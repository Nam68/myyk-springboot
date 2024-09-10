package yk.web.myyk.backend.logic.category;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.backend.factory.QueryBuilder;
import yk.web.myyk.backend.factory.QueryBuilder.Bool;
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
                .where("cat.basic = :true")
                .notDeleted()
                .setParameter("true", Bool.TRUE)
                .createQuery();
        List<CategoryEntity> categoryList = qb.getResult();
        // 계속
    }

    @Override
    public void excute() throws SystemException, AppException {
        // TODO Auto-generated method stub

    }

    @Override
    public List<CategoryDTO> getBasicCategory() {
        return categoryList;
    }

}
