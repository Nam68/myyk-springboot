package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.form.account.CreateAccountForm;
import yk.web.myyk.backend.entity.account.AccountAuthEntity;
import yk.web.myyk.backend.entity.account.AccountEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.repository.AccountAuthRepository;
import yk.web.myyk.backend.service.account.AccountService;
import yk.web.myyk.util.checker.AccountChecker;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
public class AccountLogic extends BaseLogic implements AccountService {

    @Override
    public void checkAccount(CreateAccountForm form) throws SystemException, AppException {

        long loginIdx = getLoginInfo().getMemberIdx();
        Sort descSort = AccountAuthRepository.getDescSort();
        List<AccountAuthEntity> authList = getRepository().getAccountAuth().findByMemberMemberIdx(loginIdx, descSort);

        List<String> accountNameList = new ArrayList<>();
        for (AccountAuthEntity auth : authList) {
            accountNameList.add(auth.getAccount().getAccountName());
        }

        Map<String, ErrorCode> errors = AccountChecker.checkName(form.getAccountName(), accountNameList);
        if (!errors.isEmpty()) {
            throw new AppException(errors);
        }
    }

    @Override
    @Transactional
    public void createAccount(CreateAccountForm form) throws SystemException {

        // 가계부 생성
        AccountEntity entity = new AccountEntity(form);
        getRepository().getAccount().save(entity);

        // 로그인 회원에게 모든 권한을 부여
        long loginIdx = getLoginInfo().getMemberIdx();
        form.getReadAuthList().add(loginIdx);
        form.getWriteAuthList().add(loginIdx);

        // 멤버를 불러와서 권한을 생성
        List<MemberEntity> memberList = getRepository().getMember().findByMemberIdxIn(form.getReadAuthList());
        Map<Long, AccountAuthEntity> authMap = new HashMap<>();
        for (MemberEntity member : memberList) {
            AccountAuthEntity auth = new AccountAuthEntity(member);
            authMap.put(member.getMemberIdx(), auth);
        }
        for (long memberIdx : form.getWriteAuthList()) {
            AccountAuthEntity auth = authMap.get(memberIdx);
            auth.setWritable(true);
        }
        for (Entry<Long, AccountAuthEntity> entry : authMap.entrySet()) {
            AccountAuthEntity auth = entry.getValue();
            getRepository().getAccountAuth().save(auth);
        }
    }
//	@Override
//	@Transactional
//	public Error createAccount(AccountDTO dto) throws SystemException {
//
//		AccountEntity entity = new AccountEntity(dto);
//		try {
//			getRepository().getAccount().save(entity);
//		} catch (IllegalArgumentException e) {
//			throw new SystemException(ErrorCode.AC_101, AccountLogic.class);
//		}
//		return Error.SUCCESS;
//	}
//
//	@SuppressWarnings("unused")
//    @Override
//	public List<AccountDTO> search(AccountBookDTO accountBookDto) throws SystemException {
//		List<AccountDTO> list = new ArrayList<>();
//		for (PrimeCategoryDTO primeCategory : accountBookDto.getCategoryList()) {
////			if (primeCategory.)
//		}
//		return null;
//	}

}
