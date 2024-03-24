package yk.web.myyk.backend.service.account;

public interface AccountBookService {

	/**
	 * <p>로그인된 회원의 가계부 권한 리스트를 가져온다.</p>
	 *
	 * @param memberIdx 회원 인덱스
	 * @return 가계부 권한 리스트
	 * @throws SystemException 시스템에러
	 */
//	public List<AccountBookDTO> getAuthList(long memberIdx) throws SystemException;

	/**
	 * <p>인덱스를 통해 가계부를 가져온다.</p>
	 *
	 * @param accountBookIdx 가계부 인덱스
	 * @return 가계부
	 * @throws SystemException 시스템 에러
	 */
//	AccountBookDTO getAccountBook(Long accountBookIdx) throws SystemException;

	/**
	 * <p>DTO를 통해 가계부를 생성한다.</p>
	 *
	 * @param dto 가계부 DTO
	 * @throws SystemException 시스템 에러
	 */
//	public void createBook(AccountBookDTO dto) throws SystemException;

}
