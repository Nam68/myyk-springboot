package yk.web.myyk.util.errorCode;

/**
 *  <p>에러코드 일람.</p>
 */
public enum ErrorCode {
	
	/*
	 * CF : 설정
	 * CG : 카테고리
	 * CK : 쿠키
	 * CT : 컨트롤러
	 * EN : 이넘
	 * ET : 엔티티
	 * IC : 인터셉터
	 */
	
	/**
	 * <p>로케일이 존재하지 않을 때의 에러.</p>
	 */
	CF_101("locale do not exist."),
	
	/**
	 * <p>언어 코드가 존재하지 않을 때의 에러.</p>
	 */
	CF_102("locale is not matched any languages."),
	
	/**
	 * <p>암호화에 실패했을 때의 에러.</p>
	 */
	CF_103("encryption is failed."),
	
	/**
	 * <p>프리마커 설정에 실패했을 떄의 에러.</p>
	 */
	CF_104("freemarker do not work."),
	
	/**
	 * <p>1차카테고리에 옵션이 없을 때의 에러.</p>
	 */
	CG_101("this category does not have option."),
	
	/**
	 * <p>1차카테고리에 서브카테고리가 없을 때의 에러.</p>
	 */
	CG_102("this catetory does not have sub catogory."),
	
	/**
	 * <p>1차카테고리를 서브카테고리로 취급했을 때의 에러.</p>
	 */
	CG_103("this category is not sub category."),
	
	/**
	 * <p>서브카테고리를 1차카테고리로 취급했을 때의 에러.</p>
	 */
	CG_104("this category is not prime category."),
	
	/**
	 * <p>자동 메일이 기준치 이상으로 보내졌을 떄의 에러.</p>
	 */
	CT_101("mail send failed... too many mails were sended."),
	
	/**
	 * <p>자동 로그인 정보를 생성하지 못했을 때의 에러.</p>
	 */
	CT_102("can not create auto login info."),
	
	/**
	 * <p>세션에 해당하는 값이 없을 떄의 에러.</p>
	 */
	CT_103("session value is empty"),
	
	/**
	 * <p>지역에 관한 이넘의 이름이 잘못되었을 경우의 에러.</p>
	 */
	EN_101("this region do not exist."),
	
	/**
	 * <p>존재해야할 엔티티 정보가 취득되지 않을 때의 에러.</p>
	 */
	ET_101("database is gone."),
	
	/**
	 * <p>URL 혹은 컨트롤러에 카테고리 이넘이 세팅되지 않았을 경우의 에러.</p>
	 */
	IC_101("category enum is missing or url is not exist."),
	
	;
	private String codeExplain;
	ErrorCode(String codeExplain) {
		this.codeExplain = codeExplain;
	}
	
	/**
	 * <p>에러의 설명을 반환한다. 반드시 {@link getErrorMessage}와 함께 사용할 것.</p>
	 * 
	 * @return 에러 설명
	 */
	private String getCodeExplain() {
		return codeExplain;
	}
	
	/**
	 * <p>완성된 에러 메시지를 반환한다.</p> 
	 * <p>에러가 일어난 클래스명 + 에러 설명 + (에러 코드)의 구성.</p>
	 * 
	 * @param errorCode 에러 코드
	 * @param clazz 클래스
	 * @return 에러 메시지
	 */
	public static String getErrorMessage(ErrorCode errorCode, Class<?> clazz) {
		return clazz.getSimpleName() + ": " + errorCode.getCodeExplain() + "(" + errorCode.name() + ").";
	}
}
