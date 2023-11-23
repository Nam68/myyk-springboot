package yk.web.myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>접근 권한이 있는지 체크한다.<br><br>
 * 이러한 확인을 위해서 반드시 컨트롤러 메서드 간의 정보교환은 클래스의 심플네임으로 진행하며, 처리 후 삭제할 것.
 * </p>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataCheck {

    Class<?>[] target() default {};

}
