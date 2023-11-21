package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.backend.dto.PrimeCategoryDTO;
import yk.web.myyk.backend.entity.account.AccountEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.AccountService;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

@Service
public class AccountLogic extends BaseLogic implements AccountService {
	
	@Override
	@Transactional
	public Error createAccount(AccountDTO dto) throws SystemException {
		
		AccountEntity entity = new AccountEntity(dto);
		try {
			getRepository().getAccount().save(entity);
		} catch (IllegalArgumentException e) {
			throw new SystemException(ErrorCode.AC_101, AccountLogic.class);
		}
		return Error.SUCCESS;
	}
	
	@Override
	public List<AccountDTO> search(AccountBookDTO accountBookDto) throws SystemException {
		List<AccountDTO> list = new ArrayList<>();
		for (PrimeCategoryDTO primeCategory : accountBookDto.getCategoryList()) {
//			if (primeCategory.)
		}
		return null;
	}
	
}
