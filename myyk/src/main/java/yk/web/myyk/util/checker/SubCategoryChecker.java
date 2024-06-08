package yk.web.myyk.util.checker;

import java.util.HashMap;
import java.util.Map;

import yk.web.myyk.util.constant.Constant;
import yk.web.myyk.util.errorCode.ErrorCode;

/**
 * <p>서브 카테고리를 검증한다.</p>
 */
public class SubCategoryChecker extends BaseChecker {
    /**
     * <p>서브 카테고리 이름(한국어)을 검증한다.</p>
     *
     * @param subCategoryNameKo 서브 카테고리 이름(한국어)
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkSubCategoryNameKo(String subCategoryNameKo) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(subCategoryNameKo)) {
            setError(errors, ErrorCode.EE_SC_102);
            return errors;
        }

        if (subCategoryNameKo.length() > Constant.getSubCategoryNameMax()) {
            setError(errors, ErrorCode.EE_SC_103);
        }

        return errors;
    }

    /**
     * <p>서브 카테고리 이름(일본어)을 검증한다.</p>
     *
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     * @return 에러 리스트
     */
    public static Map<String, ErrorCode> checkSubCategoryNameJp(String subCategoryNameJp) {

        Map<String, ErrorCode> errors = new HashMap<>();

        if (isEmpty(subCategoryNameJp)) {
            setError(errors, ErrorCode.EE_SC_105);
            return errors;
        }

        if (subCategoryNameJp.length() > Constant.getSubCategoryNameMax()) {
            setError(errors, ErrorCode.EE_SC_106);
        }

        return errors;
    }
}
