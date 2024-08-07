package yk.web.myyk.backend.logic.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.account.CategoryEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.CreateCategory;
import yk.web.myyk.util.checker.CategoryChecker;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateCategoryLogic extends BaseLogic implements CreateCategory {

    private long categoryIdx;

    private String categoryNameKo;

    private String categoryNameJp;

    private String categoryColor;

    private String categoryIcon;

    private Integer sortNo;

    private MemberEntity member;

    @Override
    public void setCategoryNameKo(String categoryNameKo) {
        this.categoryNameKo = categoryNameKo;
    }

    @Override
    public void setCategoryNameJp(String categoryNameJp) {
        this.categoryNameJp = categoryNameJp;
    }

    @Override
    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    @Override
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Map<String, ErrorCode> errors = new HashMap<>();

        errors.putAll(CategoryChecker.checkCategoryNameKo(categoryNameKo));
        errors.putAll(CategoryChecker.checkCategoryNameJp(categoryNameJp));
        errors.putAll(CategoryChecker.checkCategoryIcon(categoryIcon));
        errors.putAll(CategoryChecker.checkCategoryColor(categoryColor));

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        /**
         * 이름이 같은 카테고리가 있는지 검증
         */

        LoginInfo loginInfo = getLoginInfo(CreateCategoryLogic.class);
        Optional<MemberEntity> memberOptional = getRepository().getMember().findById(loginInfo.getMemberIdx());
        if (!memberOptional.isPresent()) {
            throw new SystemException(ErrorCode.LG_101, CreateCategoryLogic.class);
        }
        this.member = memberOptional.get();

        List<CategoryEntity> categoryList = this.member.getCategoryList();
        for (CategoryEntity category : categoryList) {

            // 중복되는 이름이 있으면 에러 리스트에 추가
            if (category.getCategoryNameKo().equals(categoryNameKo)) {
                ErrorCode error = loginInfo.getRegion() == Region.KOREA ? ErrorCode.EE_CA_103 : ErrorCode.EE_CA_106;
                setError(errors, error);
            }
            if (category.getCategoryNameJp().equals(categoryNameJp)) {
                ErrorCode error = loginInfo.getRegion() == Region.JAPAN ? ErrorCode.EE_CA_103 : ErrorCode.EE_CA_106;
                setError(errors, error);
            }
            if (errors.get(ErrorCode.EE_CA_103.name()) != null && errors.get(ErrorCode.EE_CA_106.name()) != null) {
                break;
            }

            // 정렬 번호를 계산
            int currentSortNo = category.getSortNo();
            if (this.sortNo == null || this.sortNo < currentSortNo) {
                this.sortNo = currentSortNo;
            }
        }

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        /**
         * 카테고리 최대치를 검증
         */
        errors.putAll(CategoryChecker.checkCategoryLimit(categoryList.size()));
        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        if (this.sortNo == null) {
            this.sortNo = Constant.getFirst();
        }

        CategoryEntity entity = new CategoryEntity(categoryNameKo, categoryNameJp, categoryColor, categoryIcon, sortNo, member);
        createCategory(entity);

        this.categoryIdx = entity.getCategoryIdx();
    }

    @Transactional
    private void createCategory(CategoryEntity entity) {
        getRepository().getCategory().save(entity);
    }

    @Override
    public long getCategoryIdx() {
        return categoryIdx;
    }
}
