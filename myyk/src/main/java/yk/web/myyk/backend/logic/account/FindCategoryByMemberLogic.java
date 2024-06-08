package yk.web.myyk.backend.logic.account;

import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.FindCategoryByMember;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindCategoryByMemberLogic extends BaseLogic implements FindCategoryByMember {

    private long memberIdx;

    private CategoryDTO category;

    @Override
    public void setMemberIdx(long memberIdx) {
        this.memberIdx = memberIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Optional<MemberEntity> member = getRepository().getMember().findById(memberIdx);
        if (!member.isPresent()) {

        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();
    }

    @Override
    public CategoryDTO getCategory() {
        return category;
    }

}
