package yk.web.myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import yk.web.myyk.util.enumerated.BaseEnum;

/**
 * <p>이넘의 모든 항목을 세팅하는 어노테이션.</p>
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SetEnum {

    /**
     * <p>설정할 이넘을 세팅한다.</p>
     */
    Class<? extends BaseEnum>[] target() default {};
}
