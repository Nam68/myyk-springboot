package yk.web.myyk.backend.logic.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.FindAccountBookByWriteAuth;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindAccountBookByWriteAuthLogic extends BaseLogic implements FindAccountBookByWriteAuth {

    private long accountBookIdx;

    private long memberIdx;

    private AccountBookEntity entity;

    private AccountBookDTO accountBook;

    @Override
    public void setAccountBookIdx(long accountBookIdx) {
        this.accountBookIdx = accountBookIdx;
    }

    @Override
    public void setMemberIdx(long memberIdx) {
        this.memberIdx = memberIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {

        // 엔티티가 존재하는지 검사
        Optional<AccountBookEntity> optional = getRepository().getAccountBook().findById(accountBookIdx);
        if (!optional.isPresent()) {
            throw new AppException(ErrorCode.AB_101);
        }

        // 논리삭제 여부 검사
        AccountBookEntity entity = optional.get();
        if (entity.isDeleted()) {
            throw new AppException(ErrorCode.AB_102);
        }

        // 쓰기권한 검사
        boolean hasAuth = false;
        List<AccountBookAuthEntity> authList = getAccountBookAuthList(entity);
        for (AccountBookAuthEntity authEntity : authList) {
            if (authEntity.isWritable() && authEntity.getMember().getMemberIdx() == memberIdx) {
                hasAuth = true;
                break;
            }
        }
        if (!hasAuth) {
            throw new AppException(ErrorCode.AB_104);
        }

        this.entity = entity;
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        AccountBookDTO dto = new AccountBookDTO(entity);
        this.accountBook = dto;
    }

    @Override
    public AccountBookDTO getAccountBook() {
        return accountBook;
    }

    @Transactional
    private List<AccountBookAuthEntity> getAccountBookAuthList(AccountBookEntity entity) {
        return entity.getAccountBookAuthList();
    }

}
