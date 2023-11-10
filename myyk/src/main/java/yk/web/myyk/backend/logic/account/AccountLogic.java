package yk.web.myyk.backend.logic.account;

import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.AccountService;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.SystemException;

@Service
public class AccountLogic extends BaseLogic implements AccountService {
	
	@Override
	public Error createAccount(AccountDTO dto) throws SystemException {
		
		return null;
	}
	
}
