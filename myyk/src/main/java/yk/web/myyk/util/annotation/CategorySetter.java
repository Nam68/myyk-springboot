package yk.web.myyk.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import yk.web.myyk.util.enumerated.Category;

/**
 * <p>해당 기능의 카테고리를 부여하는 어노테이션.</p>
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategorySetter {

	/**
	 * <p>해당 기능의 카테고리를 설정한다.</p>
	 */
	Category value() default Category.HOME;
	
}
