package yk.web.myyk.util.enumerated;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>지역에 대한 이넘.</p>
 */
public enum Region implements BaseEnum {

    /**
     * <p>한국.</p>
     */
    KOREA("ko"),

    /**
     * <p>일본.</p>
     */
    JAPAN("jp"),

    ;

    /**
     * <p>지역.</p>
     */
    private String value;

    /**
     * <p>생성자.</p>
     * 
     * @param value 지역
     */
    Region(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    /**
     * <p>문자열을 통해 지역 이넘을 반환한다.</p>
     * 
     * @param region 문자열
     * @return 지역
     */
    public static Region getRegion(String region) {
        for (Region target : Region.values()) {
            if (region.equals(target.getValue())) {
                return target;
            }
        }
        throw new SystemException(ErrorCode.EN_101, Region.class);
    }

}
