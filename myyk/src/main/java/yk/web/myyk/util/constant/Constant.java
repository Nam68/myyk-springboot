package yk.web.myyk.util.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Constant {

    private static int first;

    @Value("${value.hashing.salt}")
    private String hashingSalt;
    private static String staticHashingSalt;

    @Value("${value.hashing.times}")
    private int hashingTimes;
    private static int staticHashingTimes;

    @Value("${value.encrypt.key}")
    private String encryptKey;
    private static String staticEncryptKey;

    @Value("${value.cookie.defaultTime}")
    private int cookieDefaultTime;
    private static int staticCookieDefaultTime;

    @Value("${value.cookie.oneDay}")
    private int cookieOneDay;
    private static int staticCookieOneDay;

    @Value("${value.cookie.oneYear}")
    private int cookieOneYear;
    private static int staticCookieOneYear;

    @Value("${value.member.password.saltLength}")
    private int memberPasswordSaltLength;
    private static int staticMemberPasswordSaltLength;

    @Value("${value.member.password.hashingTimes}")
    private int memberPasswordHashingTimes;
    private static int staticMemberPasswordHashingTimes;

    @Value("${value.member.password.min}")
    private int memberPasswordMin;
    private static int staticMemberPasswordMin;

    @Value("${value.member.password.max}")
    private int memberPasswordMax;
    private static int staticMemberPasswordMax;

    @Value("${value.member.nickname.max}")
    private int memberNicknameMax;
    private static int staticMemberNicknameMax;

    @Value("${value.member.autoLogin.month}")
    private int memberAutoLoginMonth;
    private static int staticMemberAutoLoginMonth;

    @Value("${value.member.icon.default}")
    private String memberIconDefault;
    private static String staticMemberIconDefault;

    @Value("${value.tmpCode.limit.minutes}")
    private int tmpCodeLimitMinutes;
    private static int staticTmpCodeLimitMinutes;

    @Value("${value.tmpCode.limit.times}")
    private int tmpCodeLimitTimes;
    private static int staticTmpCodeLimitTimes;

    @Value("${value.url.timeout}")
    private int urlTimeout;
    private static int staticUrlTimeout;

    @Value("${value.url.try}")
    private int urlTry;
    private static int staticUrlTry;

    @Value("${value.book.name.max}")
    private int bookNameMax;
    private static int staticBookNameMax;

    @Value("${value.category.name.max}")
    private int categoryNameMax;
    private static int staticCategoryNameMax;

    @Value("${value.category.sub.name.max}")
    private int subCategoryNameMax;
    private static int staticSubCategoryNameMax;

    @PostConstruct
    public void init() {
        Constant.staticHashingSalt = hashingSalt;
        Constant.staticHashingTimes = hashingTimes;
        Constant.staticEncryptKey = encryptKey;
        Constant.staticCookieDefaultTime = cookieDefaultTime;
        Constant.staticCookieOneDay = cookieOneDay;
        Constant.staticCookieOneYear = cookieOneYear;
        Constant.staticMemberPasswordSaltLength = memberPasswordSaltLength;
        Constant.staticMemberPasswordHashingTimes = memberPasswordHashingTimes;
        Constant.staticMemberPasswordMin = memberPasswordMin;
        Constant.staticMemberPasswordMax = memberPasswordMax;
        Constant.staticMemberNicknameMax = memberNicknameMax;
        Constant.staticMemberAutoLoginMonth = memberAutoLoginMonth;
        Constant.staticMemberIconDefault = memberIconDefault;
        Constant.staticTmpCodeLimitMinutes = tmpCodeLimitMinutes;
        Constant.staticTmpCodeLimitTimes = tmpCodeLimitTimes;
        Constant.staticUrlTimeout = urlTimeout;
        Constant.staticUrlTry = urlTry;
        Constant.staticBookNameMax = bookNameMax;
        Constant.staticCategoryNameMax = categoryNameMax;
        Constant.staticSubCategoryNameMax = subCategoryNameMax;
    }

    /**
     * @return 해싱 반복 횟수
     */
    public static int getHashingTimes() {
        return staticHashingTimes;
    }

    /**
     * @return 해싱 솔트
     */
    public static String getHashingSalt() {
        return staticHashingSalt;
    }

    /**
     * @return 암호화 키
     */
    public static String getEncryptKey() {
        return staticEncryptKey;
    }

    /**
     * @return 쿠키 디폴트 시간
     */
    public static int getCookieDefaultTime() {
        return staticCookieDefaultTime;
    }

    /**
     * @return 쿠키 1일
     */
    public static int getCookieOneDay() {
        return staticCookieOneDay;
    }

    /**
     * @return 쿠키 1년
     */
    public static int getCookieOneYear() {
        return staticCookieOneYear;
    }

    /**
     * @return 회원 비밀번호 솔트 길이
     */
    public static int getMemberPasswordSaltLength() {
        return staticMemberPasswordSaltLength;
    }

    /**
     * @return 회원 비밀번호 해싱 반복 횟수
     */
    public static int getMemberPasswordHashingTimes() {
        return staticMemberPasswordHashingTimes;
    }

    /**
     * @return 비밀번호 최소 길이
     */
    public static int getMemberPasswordMin() {
        return staticMemberPasswordMin;
    }

    /**
     * @return 비밀번호 최대 길이
     */
    public static int getMemberPasswordMax() {
        return staticMemberPasswordMax;
    }

    /**
     * @return 닉네임 최대 길이
     */
    public static int getMemberNicknameMax() {
        return staticMemberNicknameMax;
    }

    /**
     * @return 회원 기본 아이콘
     */
    public static String getMemberIconDefault() {
        return staticMemberIconDefault;
    }

    /**
     * @return 회원 자동 로그인 지속 개월
     */
    public static int getMemberAutoLoginMonth() {
        return staticMemberAutoLoginMonth;
    }

    public static int getTmpCodeLImitMinutes() {
        return staticTmpCodeLimitMinutes;
    }

    /**
     * @return 임시회원 코드 마감시각
     */
    public static int getTmpCodeLimitTimes() {
        return staticTmpCodeLimitTimes;
    }

    /**
     * @return URL 타임아웃 시도 초
     */
    public static int getUrlTimeout() {
        return staticUrlTimeout;
    }

    /**
     * @return URL 타임아웃 시도 횟수
     */
    public static int getUrlTry() {
        return staticUrlTry;
    }

    /**
     * @return 가계부 이름 최대 길이
     */
    public static int getBookNameMax() {
        return staticBookNameMax;
    }

    /**
     * @return 카테고리 이름 최대 길이
     */
    public static int getCategoryNameMax() {
        return staticCategoryNameMax;
    }

    /**
     * @return 서브 카테고리 이름 최대 길이
     */
    public static int getSubCategoryNameMax() {
        return staticSubCategoryNameMax;
    }


    /**
     * @return 첫 번째 번호 (1)
     */
    public static int getFirst() {
        return first;
    }

}
