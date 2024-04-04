package yk.web.myyk.backend.logic.member;

import java.util.Optional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.entity.member.TmpCodeEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.member.FindEmailByTmpCode;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FindEmailByTmpCodeLogic extends BaseLogic implements FindEmailByTmpCode {

    private String tmpCode;

    private String email;

    private String emailLocalpart;

    private String emailDomain;

    @Override
    public void setTmpCode(String tmpCode) {
        this.tmpCode = tmpCode;
    }

    @Override
    public void validate() throws SystemException, AppException {
        Optional<TmpCodeEntity> optional = getRepository().getTmpCode().findByTmpCode(hashing(tmpCode));
        if (!optional.isPresent()) {
            throw new AppException(ErrorCode.LE_TM_101);
        }
        this.email = optional.get().getEmail();
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();
        this.emailLocalpart = getEmailLocalpart(email);
        this.emailDomain = getEmailDomain(email);
    }

    @Override
    public String getEmailLocalpart() {
        return emailLocalpart;
    }

    @Override
    public String getEmailDomain() {
        return emailDomain;
    }

}
