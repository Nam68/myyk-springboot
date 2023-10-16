package yk.web.myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import yk.web.myyk.util.enumerated.TaxRate;

/**
 * <p>컨트롤러의 메서드에 {@link TaxRate}의 세팅을 요청하는 어노테이션.</p>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TaxRateSetter {
	// nop
}
