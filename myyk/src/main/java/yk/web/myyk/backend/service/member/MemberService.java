package yk.web.myyk.backend.service.member;

import java.util.List;

import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.form.member.TmpCodeForm;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

public interface MemberService {

    /**
     * <p>임시회원 코드를 발송 가능한 이메일인지 검증한다.</p>
     * 
     * @param emailForm 이메일 정보
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public void checkTmpMember(EmailForm emailForm) throws SystemException, AppException;

    /**
     * <p>임시회원 코드를 생성한다.</p>
     * 
     * @param emailForm 이메일 정보
     * @return 임시회원 코드
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public String createTmpMember(EmailForm emailForm) throws SystemException, AppException;

    /**
     * <p>임시코드를 통해 이메일을 반환한다.</p>
     * 
     * @param tmpCodeForm 임시코드 정보
     * @return 이메일
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public String getEmailByTmpCode(TmpCodeForm tmpCodeForm) throws SystemException, AppException;

    /**
     * <p>입력된 회원 정보를 검증한다.</p>
     * 
     * @param memberForm 회원 정보
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public void checkMember(MemberForm memberForm) throws SystemException, AppException;

    /**
     * <p>회원을 생성한다.</p>
     * 
     * @param memberForm 회원 정보
     * @return 회원 이메일
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public String createMember(MemberForm memberForm) throws SystemException, AppException;

    /**
     * <p>회원의 비밀번호를 리셋한다.</p>
     * 
     * @param memberForm 회원 정보
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public void resetPassword(MemberForm memberForm) throws SystemException, AppException;

    /**
     * <p>로그인한 본인을 제외한 모든 회원을 반환한다.</p>
     * 
     * @param loginInfo 로그인 정보
     * @return 회원 리스트
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public List<MemberDto> getAllExceptSelf(LoginInfo loginInfo) throws SystemException, AppException;
}
