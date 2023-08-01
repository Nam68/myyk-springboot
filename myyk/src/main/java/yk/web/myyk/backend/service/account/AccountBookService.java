package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.util.exception.SystemException;

public interface AccountBookService {

	/**
	 * <p>회원 정보를 통해 가계부 권한 리스트를 가져온다.</p>
	 * 
	 * @param 회원 idx
	 * @return 가계부 권한 리스트
	 * @throws SystemException 시스템에러
	 */
	public List<AccountBookDTO> getAuthList(long memberIdx) throws SystemException;
	
	/**
	 * <p>DTO를 통해 가계부를 생성한다.</p>
	 * 
	 * @param dto 가계부 DTO
	 * @throws SystemException 시스템 에러
	 */
	public void createBook(AccountBookDTO dto) throws SystemException;
	
}
