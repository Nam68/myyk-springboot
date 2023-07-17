package yk.web.myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import yk.web.myyk.util.enumerated.MemberType;

/**
 * <p>접근 권한이 있는지 체크한다.</p>
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessCheck {

	/**
	 * <p>해당 등급 이상 접속 가능.</p>
	 */
	MemberType permitted() default MemberType.BANNED;
	
	/**
	 * <p>해당 등급은 접속 불가.</p>
	 */
	MemberType[] denied() default {};
	
}
