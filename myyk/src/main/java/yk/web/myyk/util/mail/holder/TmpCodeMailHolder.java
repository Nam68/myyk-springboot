package yk.web.myyk.util.mail.holder;

/**
 * <p>회원가입 임시코드 메일 홀더.</p>
 */
public class TmpCodeMailHolder extends BaseMailHolder {

    /**
     * <p>본문.</p>
     */
    private String message = "";

    /**
     * <p>코드안내.</p>
     */
    private String code = "";

    /**
     * <p>생성자.</p>
     * 
     * @param message 본문
     * @param code 코드안내
     */
    public TmpCodeMailHolder(String message, String code) {
        this.message = message;
        this.code = code;
    }

    /**
     * <p>본문을 반환한다.</p>
     * 
     * @return 본문
     */
    public String getMessage() {
        return message;
    }

    /**
     * <p>코드안내를 반환한다.</p>
     * 
     * @return 코드안내
     */
    public String getCode() {
        return code;
    }
}
