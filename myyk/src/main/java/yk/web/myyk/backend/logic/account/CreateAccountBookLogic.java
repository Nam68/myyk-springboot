package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.CreateAccountBook;
import yk.web.myyk.util.checker.AccountChecker;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateAccountBookLogic extends BaseLogic implements CreateAccountBook {

    private String accountBookNameKr;

    private String accountBookNameJp;

    private boolean taxInclude;

    private TaxRate taxRate;

    private Currency currency;

    private List<Long> readAuthList;

    private List<Long> writeAuthList;

    @Override
    public void setAccountBookNameKr(String accountBookNameKr) {
        this.accountBookNameKr = accountBookNameKr;
    }

    @Override
    public void setAccountBookNameJp(String accountBookNameJp) {
        this.accountBookNameJp = accountBookNameJp;
    }

    @Override
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void setReadAuthList(List<Long> readAuthList) {
        this.readAuthList = readAuthList;
    }

    @Override
    public void setWriteAuthList(List<Long> writeAuthList) {
        this.writeAuthList = writeAuthList;
    }

    @Override
    public void validate() throws SystemException, AppException {

        Map<String, ErrorCode> errors = new HashMap<>();

        errors.putAll(AccountChecker.checkAccountBookNameKr(accountBookNameKr));
        errors.putAll(AccountChecker.checkAccountBookNameJp(accountBookNameJp));

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        long loginIdx = getLoginInfo(CreateAccountBookLogic.class).getMemberIdx();
        Sort descSort = SortUtil.getRegisteredDateDesc();
        List<AccountBookAuthEntity> authList = getRepository().getAccountBookAuth().findByMemberMemberIdx(loginIdx, descSort);

        for (AccountBookAuthEntity auth : authList) {
            if (auth.getAccount().getAccountBookNameKr().equals(accountBookNameKr)) {
                setError(errors, ErrorCode.EE_AC_103);
                break;
            }
            if (auth.getAccount().getAccountBookNameJp().equals(accountBookNameJp)) {
                setError(errors, ErrorCode.EE_AC_106);
                break;
            }
        }

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        // 가계부 생성
        saveAccountEntity();

        // 로그인 회원에게 모든 권한을 부여
        long loginIdx = getLoginInfo(CreateAccountBookLogic.class).getMemberIdx();
        readAuthList.add(loginIdx);
        writeAuthList.add(loginIdx);

        // 멤버를 불러와서 권한을 생성
        List<MemberEntity> memberList = getRepository().getMember().findByMemberIdxIn(readAuthList);
        Map<Long, AccountBookAuthEntity> authMap = new HashMap<>();
        for (MemberEntity member : memberList) {
            AccountBookAuthEntity auth = new AccountBookAuthEntity(member);
            authMap.put(member.getMemberIdx(), auth);
        }
        for (long memberIdx : writeAuthList) {
            AccountBookAuthEntity auth = authMap.get(memberIdx);
            auth.setWritable(true);
        }

        // 생성한 권한을 저장
        saveAccountAuthList(authMap);
    }

    @Transactional
    private void saveAccountEntity() {
        AccountBookEntity entity = new AccountBookEntity(accountBookNameKr, accountBookNameJp, currency);
        getRepository().getAccountBook().save(entity);
    }

    @Transactional
    private void saveAccountAuthList(Map<Long, AccountBookAuthEntity> authMap) {
        List<AccountBookAuthEntity> authList = new ArrayList<>();
        for (Entry<Long, AccountBookAuthEntity> entry : authMap.entrySet()) {
            authList.add(entry.getValue());
        }
        getRepository().getAccountBookAuth().saveAll(authList);
    }

}
