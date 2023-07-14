package yk.web.myyk.util.errorCode;

/**
 *  <p>에러코드 일람.</p>
 */
public enum ErrorCode {
	
	/*
	 * IC : 인터셉터
	 * EN : 이넘
	 * CT : 컨트롤러
	 * CK : 쿠키
	 */
	
	/**
	 * <p>URL 혹은 컨트롤러에 카테고리 이넘이 세팅되지 않았을 경우의 에러.</p>
	 */
	IC_101("category enum is missing or url is not exist."),
	
	/**
	 * <p>지역에 관한 이넘의 이름이 잘못되었을 경우의 에러.</p>
	 */
	EN_101("this region do not exist."),
	
	/**
	 * <p>자동 메일이 기준치 이상으로 보내졌을 떄의 에러.</p>
	 */
	CT_101("mail send failed... too many mails were sended."),
	
	/**
	 * <p>쿠키가 존재하지 않을 경우의 에러.</p>
	 */
	CK_101("cookie do not exist.")
	
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
