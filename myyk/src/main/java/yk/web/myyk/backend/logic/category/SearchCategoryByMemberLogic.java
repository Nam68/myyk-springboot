package yk.web.myyk.backend.logic.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.category.CategoryEntity;
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

    private Locale locale;

    private long memberIdx;

    private List<CategoryDTO> categoryList;

    @Override
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void validate() throws SystemException, AppException {
        LoginInfo loginInfo = getLoginInfo(CreateCategoryLogic.class);
        this.memberIdx = loginInfo.getMemberIdx();

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
            if (entity.isBasic() || entity.isDeleted()) {
                // 기본 카테고리 || 삭제 카테고리를 제외
                continue;
            }
            CategoryDTO dto = new CategoryDTO(entity);
            list.add(dto);
        }
        this.categoryList = list;
    }

    @Override
    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

}
