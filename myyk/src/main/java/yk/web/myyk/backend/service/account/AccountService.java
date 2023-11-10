package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.exception.SystemException;

public interface AccountService {

	/**
	 * <p>회계 정보를 생성한다.</p>
	 * 
	 * @param dto 회계DTO
	 * @return 성공여부
	 * @throws SystemException 시스템에러
	 */
	public Error createAccount(AccountDTO dto) throws SystemException;
	
}
