package yk.web.myyk.backend.logic.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.category.CategoryEntity;
import yk.web.myyk.backend.entity.category.SubCategoryEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.CreateSubCategory;
import yk.web.myyk.util.checker.SubCategoryChecker;
import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateSubCategoryLogic extends BaseLogic implements CreateSubCategory {

    private String subCategoryNameKo;

    private String subCategoryNameJp;

    private Long categoryIdx;

    private SubCategoryDTO subCategory;

    private Integer sortNo;

    private CategoryEntity category;

    @Override
    public void setSubCategoryNameKo(String subCategoryNameKo) {
        this.subCategoryNameKo = subCategoryNameKo;
    }

    @Override
    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }

    @Override
    public void setCategoryIdx(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Map<String, ErrorCode> errors = new HashMap<>();

        errors.putAll(SubCategoryChecker.checkSubCategoryNameKo(subCategoryNameKo));
        errors.putAll(SubCategoryChecker.checkSubCategoryNameJp(subCategoryNameJp));

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        /**
         * 로그인 정보를 통한 서브 카테고리 취득
         */

        LoginInfo loginInfo = getLoginInfo(CreateCategoryLogic.class);
        Optional<MemberEntity> memberOptional = getRepository().getMember().findById(loginInfo.getMemberIdx());
        if (!memberOptional.isPresent()) {
            throw new SystemException(ErrorCode.LG_101, CreateCategoryLogic.class);
        }

        Optional<CategoryEntity> categoryOptional = getRepository().getCategory().findById(categoryIdx);
        if (!categoryOptional.isPresent()) {
            throw new SystemException(ErrorCode.EE_SC_101, CreateSubCategoryLogic.class);
        }
        this.category = categoryOptional.get();

        List<SubCategoryEntity> subCategoryEntityList = categoryOptional.get().getSubCategoryList();

        /**
         * 이름이 같은 카테고리가 있는지 검증
         */

        for (SubCategoryEntity subCategoryEntity : subCategoryEntityList) {
            // 중복되는 이름이 있으면 에러 리스트에 추가
            if (subCategoryEntity.getSubCategoryNameKo().equals(subCategoryNameKo)) {
                ErrorCode error = loginInfo.getRegion() == Region.KOREA ? ErrorCode.EE_SC_104 : ErrorCode.EE_SC_107;
                setError(errors, error);
            }
            if (subCategoryEntity.getSubCategoryNameJp().equals(subCategoryNameJp)) {
                ErrorCode error = loginInfo.getRegion() == Region.JAPAN ? ErrorCode.EE_SC_104 : ErrorCode.EE_SC_107;
                setError(errors, error);
            }
            if (errors.get(ErrorCode.EE_SC_104.name()) != null && errors.get(ErrorCode.EE_SC_107.name()) != null) {
                break;
            }

            // 정렬 번호를 계산
            int currentSortNo = subCategoryEntity.getSortNo();
            if (this.sortNo == null || this.sortNo < currentSortNo) {
                this.sortNo = currentSortNo;
            }
        }

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        /**
         * 서브 카테고리 숫자가 최대치를 초과하는지 검증
         */

        errors.putAll(SubCategoryChecker.checkSubCategoryLimit(subCategoryEntityList.size()));
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

        SubCategoryEntity entity = new SubCategoryEntity(subCategoryNameKo, subCategoryNameJp, sortNo, category);
        createSubCategory(entity);

        this.subCategory = new SubCategoryDTO(entity);
    }

    @Transactional
    private void createSubCategory(SubCategoryEntity entity) {
        getRepository().getSubCategory().save(entity);
    }

    @Override
    public SubCategoryDTO getSubCategory() {
        return subCategory;
    }
}
