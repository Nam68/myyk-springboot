package yk.web.myyk.util.enumerated;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public enum TaxRate implements BaseEnum {

    LOW("8%", 0.08),
    HIGH("10%", 0.1),
    ;

    private String display;

    private double rate;
    
    private TaxRate(String display, double rate) {
        this.display = display;
        this.rate = rate;
    }

    @Override
    public String getValue() {
        return display;
    }

    public double getRate() {
        return rate;
    }

    /**
     * 숫자를 통해 세율을 반환한다.
     * 
     * @param rate 세율 단위
     * @return 세율
     */
    public static TaxRate getTaxRate(double rate) {
        for (TaxRate target : TaxRate.values()) {
            if (target.getRate() == rate) {
                return target;
            }
        }
        throw new SystemException(ErrorCode.EN_102, TaxRate.class);
    }

}
