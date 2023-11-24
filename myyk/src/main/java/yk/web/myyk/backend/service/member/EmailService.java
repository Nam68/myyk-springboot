package yk.web.myyk.backend.service.member;

import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

public interface EmailService {

    /**
     * <p>임시회원 코드를 발송한다.</p>
     * 
     * @param emailForm 이메일 정보
     * @param tmpCode 임시회원 코드
     * @throws SystemException 시스템에러
     */
    public void sendTmpMemberCode(EmailForm emailForm, String tmpCode) throws SystemException, AppException;

//	/**
//	 * <p>임시코드가 포함된 이메일을 발송하며, 이메일과 임시코드를 임시회원으로 저장한다.</p>
//	 * 
//	 * @param email 이메일
//	 * @throws SystemException 시스템 에러
//	 */
//	public void sendEmailConfirm(String email) throws SystemException;
//	
//	/**
//	 * <p>이메일 인증코드를 체크한다.
//	 * <br>관련 임시회원이 검색된 경우는 임시회원을 삭제한다.
//	 * <br>관련 임시회원이 없는 경우는 에러를 반환한다.
//	 * </p>
//	 * 
//	 * @param tmpCode 유저가 입력한 인증코드
//	 * @return 임시회원 이메일 또는 열거형 에러
//	 * @throws SystemException 시스템 에러
//	 */
//	public String checkTmpCode(int tmpCode) throws SystemException;
	
}
