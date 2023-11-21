package yk.web.myyk.util.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Constant {

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

    @Value("${value.member.password.saltLength}")
    private int memberPasswordSaltLength;
    private static int staticMemberPasswordSaltLength;

    @Value("${value.member.password.hashingTimes}")
    private int memberPasswordHashingTimes;
    private static int staticMemberPasswordHashingTimes;

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

    @PostConstruct
    public void init() {
        Constant.staticHashingSalt = hashingSalt;
        Constant.staticHashingTimes = hashingTimes;
        Constant.staticEncryptKey = encryptKey;
        Constant.staticCookieDefaultTime = cookieDefaultTime;
        Constant.staticCookieOneDay = cookieOneDay;
        Constant.staticMemberPasswordSaltLength = memberPasswordSaltLength;
        Constant.staticMemberPasswordHashingTimes = memberPasswordHashingTimes;
        Constant.staticMemberIconDefault = memberIconDefault;
        Constant.staticTmpCodeLimitMinutes = tmpCodeLimitMinutes;
        Constant.staticTmpCodeLimitTimes = tmpCodeLimitTimes;
        Constant.staticUrlTimeout = urlTimeout;
        Constant.staticUrlTry = urlTry;
    }

    public static int getHashingTimes() {
        return staticHashingTimes;
    }

    public static String getHashingSalt() {
        return staticHashingSalt;
    }

    public static String getEncryptKey() {
        return staticEncryptKey;
    }

    public static int getCookieDefaultTime() {
        return staticCookieDefaultTime;
    }

    public static int getCookieOneDay() {
        return staticCookieOneDay;
    }

    public static int getMemberPasswordSaltLength() {
        return staticMemberPasswordSaltLength;
    }

    public static int getMemberPasswordHashingTimes() {
        return staticMemberPasswordHashingTimes;
    }

    public static String getMemberIconDefault() {
        return staticMemberIconDefault;
    }

    public static int getTmpCodeLImitMinutes() {
        return staticTmpCodeLimitMinutes;
    }

    public static int getTmpCodeLImitTimes() {
        return staticTmpCodeLimitTimes;
    }

    public static int getUrlTimeout() {
        return staticUrlTimeout;
    }

    public static int getUrlTry() {
        return staticUrlTry;
    }

}