package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.entity.account.AccountAuthEntity;
import yk.web.myyk.backend.entity.account.AccountEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.CreateAccount;
import yk.web.myyk.util.checker.AccountChecker;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;
import yk.web.myyk.util.sort.SortUtil;

@Service
public class CreateAccountLogic extends BaseLogic implements CreateAccount {

    private String accountName;

    private boolean taxInclude;

    private TaxRate taxRate;

    private Currency currency;

    private List<Long> readAuthList;

    private List<Long> writeAuthList;

    @Override
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public void setTaxInclude(boolean taxInclude) {
        this.taxInclude = taxInclude;
    }

    @Override
    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
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

        errors.putAll(AccountChecker.checkName(accountName));

        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }

        long loginIdx = getLoginInfo(CreateAccountLogic.class).getMemberIdx();
        Sort descSort = SortUtil.getRegisteredDateDesc();
        List<AccountAuthEntity> authList = getRepository().getAccountAuth().findByMemberMemberIdx(loginIdx, descSort);

        for (AccountAuthEntity auth : authList) {
            if (auth.getAccount().getAccountName().equals(accountName)) {
                setError(errors, ErrorCode.EE_AC_103);
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
        long loginIdx = getLoginInfo(CreateAccountLogic.class).getMemberIdx();
        readAuthList.add(loginIdx);
        writeAuthList.add(loginIdx);

        // 멤버를 불러와서 권한을 생성
        List<MemberEntity> memberList = getRepository().getMember().findByMemberIdxIn(readAuthList);
        Map<Long, AccountAuthEntity> authMap = new HashMap<>();
        for (MemberEntity member : memberList) {
            AccountAuthEntity auth = new AccountAuthEntity(member);
            authMap.put(member.getMemberIdx(), auth);
        }
        for (long memberIdx : writeAuthList) {
            AccountAuthEntity auth = authMap.get(memberIdx);
            auth.setWritable(true);
        }

        // 생성한 권한을 저장
        saveAccountAuthList(authMap);
    }

    @Transactional
    private void saveAccountEntity() {
        AccountEntity entity = new AccountEntity(accountName, taxInclude, taxRate, currency);
        getRepository().getAccount().save(entity);
    }

    @Transactional
    private void saveAccountAuthList(Map<Long, AccountAuthEntity> authMap) {
        List<AccountAuthEntity> authList = new ArrayList<>();
        for (Entry<Long, AccountAuthEntity> entry : authMap.entrySet()) {
            authList.add(entry.getValue());
        }
        getRepository().getAccountAuth().saveAll(authList);
    }

}
