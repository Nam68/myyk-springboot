package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.dto.AccountBookDTO;
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
	
	/**
	 * <p>가계부에 등록된 모든 회계 정보를 반환한다.</p>
	 * 
	 * @param accountBookDto 가계부DTO
	 * @return 회계 리스트
	 * @throws SystemException 시스템에러
	 */
	public List<AccountDTO> search(AccountBookDTO accountBookDto) throws SystemException;
}
