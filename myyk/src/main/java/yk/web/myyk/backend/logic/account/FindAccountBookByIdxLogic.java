package yk.web.myyk.backend.logic.account;

import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.FindAccountBookByIdx;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindAccountBookByIdxLogic extends BaseLogic implements FindAccountBookByIdx {

    private long accountBookIdx;

    private AccountBookEntity entity;

    private AccountBookDTO accountBook;

    @Override
    public void setAccountBookIdx(long accountBookIdx) {
        this.accountBookIdx = accountBookIdx;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Optional<AccountBookEntity> optional = getRepository().getAccountBook().findById(accountBookIdx);
        if (!optional.isPresent()) {
            throw new AppException(ErrorCode.AB_101);
        }

        AccountBookEntity entity = optional.get();
        if (entity.isDeleted()) {
            throw new AppException(ErrorCode.AB_102);
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

}
