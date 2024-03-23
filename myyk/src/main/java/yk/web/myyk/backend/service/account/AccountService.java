package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.dto.form.account.CreateAccountForm;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

public interface AccountService {

    /**
     * <p>가계부 정보를 검증한다.</p>
     * 
     * @param form 가계부 폼
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public void checkAccount(CreateAccountForm form) throws SystemException, AppException;

    /**
     * <p>가계부를 생성한다.</p>
     * 
     * @param form 가계부 폼
     * @return 성공여부
     * @throws SystemException 시스템에러
     */
    public void createAccount(CreateAccountForm form) throws SystemException;

	/**
	 * <p>가계부에 등록된 모든 회계 정보를 반환한다.</p>
	 * 
	 * @param accountBookDto 가계부DTO
	 * @return 회계 리스트
	 * @throws SystemException 시스템에러
	 */
//	public List<AccountDTO> search(AccountBookDTO accountBookDto) throws SystemException;
}
