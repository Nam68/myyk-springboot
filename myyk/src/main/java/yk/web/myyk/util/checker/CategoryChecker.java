package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>카테고리를 검증한다.</p>
 */
public class CategoryChecker extends BaseChecker {

    /**
     * <p>카테고리 이름(한국어)을 검증한다.</p>
     *
     * @param categoryNameKr 카테고리 이름(한국어)
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkCategoryNameKr(String categoryNameKr) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(categoryNameKr)) {
            setError(errors, ErrorCode.EE_CA_101);
            return errors;
        }

        if (categoryNameKr.length() > Constant.getCategoryNameMax()) {
            setError(errors, ErrorCode.EE_CA_102);
        }

        return errors;
    }

    /**
     * <p>카테고리 이름(일본어)을 검증한다.</p>
     *
     * @param categoryNameJp 카테고리 이름(일본어)
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkCategoryNameJp(String categoryNameJp) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(categoryNameJp)) {
            setError(errors, ErrorCode.EE_CA_104);
            return errors;
        }

        if (categoryNameJp.length() > Constant.getCategoryNameMax()) {
            setError(errors, ErrorCode.EE_CA_105);
        }

        return errors;
    }

    /**
     * <p>카테고리 아이콘을 검증한다.</p>
     *
     * @param categoryIcon 카테고리 아이콘
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkCategoryIcon(String categoryIcon) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(categoryIcon)) {
            setError(errors, ErrorCode.EE_CA_107);
        }

        return errors;
    }

    /**
     * <p>카테고리 색을 검증한다.</p>
     *
     * @param categoryColor 카테고리 색
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkCategoryColor(String categoryColor) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(categoryColor)) {
            setError(errors, ErrorCode.EE_CA_109);
            return errors;
        }

        if (!isCorrectColorCode(categoryColor)) {
            setError(errors, ErrorCode.EE_CA_110);
            return errors;
        }

        return errors;
    }

    /**
     * <p>카테고리 제한을 검증한다.</p>
     *
     * @param currentCategoryLength 현재 카테고리 수
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkCategoryLimit(int currentCategoryLength) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isWithoutLimit(Constant.getCategoryLimit(), currentCategoryLength)) {
            setError(errors, ErrorCode.EE_CA_111);
        }
        return errors;
    }
}
