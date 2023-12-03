package yk.web.myyk.backend.service.member;

import yk.web.myyk.backend.dto.form.member.EmailForm;
import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.form.member.TmpCodeForm;
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
     * <p>입력된 회원 정보를 검증한다.</p>
     * 
     * @param memberForm 회원 정보
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public void checkMember(MemberForm memberForm) throws SystemException, AppException;

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
     * <p>임시코드를 통해 이메일을 가져온다.</p>
     * 
     * @param tmpCodeForm 임시코드 정보
     * @return 이메일
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public String getEmailByTmpCode(TmpCodeForm tmpCodeForm) throws SystemException, AppException;

    /**
     * <p>회원을 생성한다.</p>
     * 
     * @param memberForm 회원 정보
     * @return 회원 이메일
     * @throws SystemException 시스템에러
     * @throws AppException 앱에러
     */
    public String createMember(MemberForm memberForm) throws SystemException, AppException;

//    /**
//     * <p>임시 코드를 통해 이메일을 찾아낸다.</p>
//     * 
//     * @param tmpCode 임시코드
//     * @return 이메일
//     * @throws SystemException 시스템 에러
//     */
//    public String findMailByTmpCode(EmailTmpCodeForm form) throws SystemException, AppException;
//	
//	/**
//	 * <p>이메일이 존재하는지 검증한다.</p>
//	 * 
//	 * @param email 이메일
//	 * @return 에러
//	 * @throws SystemException 시스템 에러
//	 */
//	public Map<String, String> emailValidate(String email) throws SystemException;
//	
//	/**
//	 * <p>신규가입 회원정보를 검증한다.</p>
//	 * 
//	 * @param dto 회원
//	 * @return 에러
//	 * @throws SystemException 시스템 에러
//	 */
//	public Map<String, String> createVaildate(MemberDTO dto) throws SystemException;
//
//	/**
//	 * <p>회원을 생성한다.</p>
//	 * 
//	 * @param dto 회원
//	 * @throws SystemException 시스템 에러
//	 */
//	public void create(MemberDTO dto) throws SystemException;
//	
//	/**
//	 * <p>회원 등급에 해당하는 모든 회원을 불러온다.</p>
//	 * 
//	 * @param memberType 회원등급
//	 * @return 회원 리스트
//	 * @throws SystemException 시스템 에러
//	 */
//	public List<MemberDTO> findAllByMemberType(MemberType memberType) throws SystemException;
//	
//	/**
//	 * <p>관리자와 회원 등급에 해당하는 모든 회원을 불러온다.</p>
//	 * 
//	 * @return 회원 리스트
//	 * @throws SystemException 시스템 에러
//	 */
//	public List<MemberDTO> findAllAdminAndMember() throws SystemException;
//	
//	/**
//	 * <p>로그인 유저를 제외한 관리자와 회원 등급에 해당하는 모든 회원을 불러온다.</p>
//	 * 
//	 * @param loginInfo 로그인 유저
//	 * @return 회원 리스트
//	 * @throws SystemException 시스템 에러
//	 */
//	public List<MemberDTO> findAllAdminAndMember(LoginInfo loginInfo) throws SystemException;
	
}
