package yk.web.myyk.util.enumerated;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public enum Currency implements BaseEnum {

    WON("won"),
    YEN("yen"),
    ;

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    @Override
    public String getValue() {
        return currency;
    }

    /**
     * <p>문자열을 통해 통화단위를 반환한다.</p>
     * 
     * @param region 문자열
     * @return 통화단위
     */
    public static Currency getCurrency(String currency) {
        for (Currency target : Currency.values()) {
            if (currency.equals(target.getValue())) {
                return target;
            }
        }
        throw new SystemException(ErrorCode.EN_101, Currency.class);
    }
}
