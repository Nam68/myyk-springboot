package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import yk.web.myyk.util.annotation.SetEnum;
import yk.web.myyk.util.enumerated.BaseEnum;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.enumerated.TaxRate;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>이넘의 모든 값을 설정하는 인터셉터.</p>
 * 
 * "EnumName.ENUM_ITEM" = value
 */
public class SetEnumInterceptor extends BaseInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HandlerMethod hm = getHandlerMethod(handler);
        if (hm == null) {
            return true;
        }

        SetEnum anno = getAnnotation(SetEnum.class, hm);
        if (anno == null) {
            return true;
        }

        Class<? extends BaseEnum>[] enumList = anno.target();

        for (Class<? extends BaseEnum> enumClass : enumList) {

            String enumName = enumClass.getSimpleName();

            if (Region.class.getSimpleName().equals(enumName)) {
                request.setAttribute(enumName, Region.values());
            } else if (TaxRate.class.getSimpleName().equals(enumName)) {
                request.setAttribute(enumName, TaxRate.values());
            } else if (Currency.class.getSimpleName().equals(enumName)) {
                request.setAttribute(enumName, Currency.values());
            } else {
                throw new SystemException(ErrorCode.EN_102, SetEnumInterceptor.class);
            }
        }

        return true;
    }
}
