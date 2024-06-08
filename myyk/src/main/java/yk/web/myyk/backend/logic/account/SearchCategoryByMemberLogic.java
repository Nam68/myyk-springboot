package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.SearchCategoryByMember;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SearchCategoryByMemberLogic extends BaseLogic implements SearchCategoryByMember {

    private long memberIdx;

    private List<CategoryDTO> categoryList;

    @Override
    public void validate() throws SystemException, AppException {
        LoginInfo loginInfo = getLoginInfo(CreateCategoryLogic.class);
        this.memberIdx = loginInfo.getMemberIdx();
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<CategoryEntity> entityList = getRepository().getCategory().findAllByMemberMemberIdx(memberIdx, SortUtil.getSortNoAsc());

        List<CategoryDTO> list = new ArrayList<>();
        for (CategoryEntity entity : entityList) {
            CategoryDTO dto = new CategoryDTO(entity);
            list.add(dto);
        }
        this.categoryList = list;
    }

    @Override
    public List<CategoryDTO> getCategoryList() throws SystemException {
        return categoryList;
    }

}
