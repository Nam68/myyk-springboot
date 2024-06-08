package yk.web.myyk.util.errorCode;

/**
 *  <p>에러코드 일람.</p>
 */
public enum ErrorCode {

    /*
     * AB : 가계부
     * AC : 회계
     * CF : 설정
     * CG : 카테고리
     * CK : 쿠키
     * CT : 컨트롤러
     * EN : 이넘
     * ET : 엔티티
     * IC : 인터셉터
     * LG : 로그인
     * MA : 메일
     * SS : 세션값
     */

    /**
     * <p>가계부 엔티티를 찾을 수 없을 때의 에러.</p>
     */
    AB_101("account book entity does not exist."),

    /**
     * <p>회계 엔티티 생성에 실패했을 때의 에러.</p>
     */
    AC_101("account can not be created."),

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
     * <p>카테고리가 존재하지 않았을 때의 에러.</p>
     */
    CG_101("this category do not exist."),

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
     * <p>해당 이넘이 존재하지 않을 때의 에러.</p>
     */
    EN_102("this enum does not exist."),

    /**
     * <p>존재해야할 엔티티 정보가 취득되지 않을 때의 에러.</p>
     */
    ET_101("database is gone."),

    /**
     * <p>URL 혹은 컨트롤러에 카테고리 이넘이 세팅되지 않았을 경우의 에러.</p>
     */
    IC_101("category enum is missing or url is not exist."),

    /**
     * <p>필수 데이터가 세팅되지 않았을 경우의 에러.</p>
     */
    IC_102("data is not set."),

    /**
     * <p>로그인 정보가 존재하지 않았을 경우의 에러.</p>
     */
    LG_101("login data does not exist."),

    /**
     * <p>메일 전송 시의 에러.</p>
     */
    MA_101("failed to send mail."),

    /**
     * <p>프리마커 템플레이트 생성 실패.</p>
     */
    MA_102("failed to get freemarker template."),

    /**
     * <p>프리마커 템플레이트 랜더링 실패.</p>
     */
    MA_103("failed to render freemarker."),

    /**
     * <p>세션 언어값이 비어있는 경우.</p>
     */
    SS_101("selected language is empty."),

    /**
     * <p>세션 언어값이 문자열이 아닌 경우.</p>
     */
    SS_102("selected language is not string."),

    /**
     * <p>세션 언어값이 잘못된 값일 경우.</p>
     */
    SS_103("selected language is unvalated."),

    /*
     * 엔티티 에러
     *
     * AC : 가계부
     * CA : 카테고리
     * ME : 회원
     * SC : 서브카테고리
     */

    /**
     * <p>가계부 이름이 비어있는 경우.</p>
     */
    EE_AC_101("account book name is empty."),

    /**
     * <p>가계부 이름 최대길이를 초과한 경우.</p>
     */
    EE_AC_102("account book name is too long."),

    /**
     * <p>가계부 이름이 중복된 경우.</p>
     */
    EE_AC_103("this account book name exists already."),

    /**
     * <p>가계부 이름(타언어)이 비어있는 경우.</p>
     */
    EE_AC_104("account book name (other language) is empty."),

    /**
     * <p>가계부 이름 최대길이를 초과한 경우(타언어).</p>
     */
    EE_AC_105("account book name (other language) is too long."),

    /**
     * <p>가계부 이름(타언어)이 중복된 경우.</p>
     */
    EE_AC_106("this account book name (other language) exists already."),

    /**
     * <p>카테고리 이름이 비어있는 경우.</p>
     */
    EE_CA_101("category name is empty."),

    /**
     * <p>카테고리 이름이 10자를 초과하는 경우.</p>
     */
    EE_CA_102("category name is too long."),

    /**
     * <p>다른 카테고리 이름이 이미 존재하는 경우.</p>
     */
    EE_CA_103("this category name exists already."),

    /**
     * <p>카테고리 이름(다언어)이 비어있는 경우.</p>
     */
    EE_CA_104("category name (other language) is empty."),

    /**
     * <p>카테고리 이름(다언어)이 10자를 초과하는 경우.</p>
     */
    EE_CA_105("category name (other language) is too long."),

    /**
     * <p>다른 카테고리 이름(다언어)이 이미 존재하는 경우.</p>
     */
    EE_CA_106("this category (other language) name exists already."),

    /**
     * <p>부트스트랩에 아이콘 이름이 비어있는 경우.</p>
     */
    EE_CA_107("icon name is empty."),

    /**
     * <p>부트스트랩에 아이콘 이름이 존재하지 않는 경우.</p>
     */
    EE_CA_108("this icon does not exist in bootstrap."),

    /**
     * <p>카테고리 색이 존재하지 않는 경우.</p>
     */
    EE_CA_109("category color is empty."),

    /**
     * <p>카테고리 색의 형식이 잘못된 경우.</p>
     */
    EE_CA_110("category color code is wrong."),

    /**
     * <p>이메일 로컬파트가 빈 값인 경우.</p>
     */
    EE_ME_101("local part of email can not empty."),

    /**
     * <p>이메일 도메인이 빈 값인 경우.</p>
     */
    EE_ME_102("email domain can not empty"),

    /**
     * <p>이메일 도메인이 올바른 형식이 아닌 경우.</p>
     */
    EE_ME_103("email domain is wrong."),

    /**
     * <p>이미 존재하는 회원의 이메일인 경우.</p>
     * <p>잘못된 코드이나 이미 이후 번호가 채워져서 살려둠. {@link LE_ME_101} 참고.</p>
     */
    @Deprecated
    EE_ME_104("this email exists already."),

    /**
     * <p>임시코드로 찾는 이메일이 존재하지 않는 경우.</p>
     */
    EE_ME_105("temporary code is not registered or deleted."),

    /**
     * <p>비밀번호가 비어있는 경우.</p>
     */
    EE_ME_106("password is empty."),

    /**
     * <p>비밀번호가 8자가 되지 않는 경우.</p>
     */
    EE_ME_107("password is too short."),

    /**
     * <p>비밀번호가 30자 이상인 경우.</p>
     */
    EE_ME_108("password is too long."),

    /**
     * <p>비밀번호가 대소문자 숫자 조합이 아닌 경우.</p>
     */
    EE_ME_109("password must be have alphabet upper cases, lower cases and numbers."),

    /**
     * <p>비밀번호 확인이 일치하지 않는 경우.</p>
     */
    EE_ME_110("password does not match."),

    /**
     * <p>닉네임이 비어있는 경우 경우.</p>
     */
    EE_ME_111("nickname is empty."),

    /**
     * <p>닉네임이 10자를 넘어선 경우.</p>
     */
    EE_ME_112("nickname is too long."),

    /**
     * <p>닉네임이 비어있는 경우 경우.</p>
     */
    EE_ME_113("nickname is empty."),

    /**
     * <p>닉네임이 10자를 넘어선 경우.</p>
     */
    EE_ME_114("nickname is too long."),

    /**
     * <p>카테고리가 존재하지 않는 경우.</p>
     */
    EE_SC_101("cateogry does not exist."),

    /**
     * <p>카테고리 이름(다언어)이 비어있는 경우.</p>
     */
    EE_SC_102("sub category name is empty."),

    /**
     * <p>카테고리 이름(다언어)이 10자를 초과하는 경우.</p>
     */
    EE_SC_103("sub category name is too long."),

    /**
     * <p>다른 카테고리 이름(다언어)이 이미 존재하는 경우.</p>
     */
    EE_SC_104("this sub category name exists already."),

    /**
     * <p>카테고리 이름(다언어)이 비어있는 경우.</p>
     */
    EE_SC_105("sub category name (other language) is empty."),

    /**
     * <p>카테고리 이름(다언어)이 10자를 초과하는 경우.</p>
     */
    EE_SC_106("sub category name (other language) is too long."),

    /**
     * <p>다른 카테고리 이름(다언어)이 이미 존재하는 경우.</p>
     */
    EE_SC_107("this sub category (other language) name exists already."),


    /*
     * 논리 에러
     *
     * ME : 회원
     * LG : 로그인
     * TM : 임시회원
     */

    /**
     * <p>이미 존재하는 회원의 이메일인 경우.</p>
     */
    LE_ME_101("email is duplicated."),

    /**
     * <p>닉네임이 중복된 경우.</p>
     */
    LE_ME_102("nickname is duplicated."),

    /**
     * <p>닉네임 타언어가 중복된 경우.</p>
     */
    LE_ME_103("nickname for another language is duplicated."),

    /**
     * <p>로그인 에러.</p>
     */
    LE_LG_101("login error."),

    /**
     * <p>임시회원코드가 존재하지 않음.</p>
     */
    LE_TM_101("temporary code does not exist.")

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
