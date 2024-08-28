package yk.web.myyk.backend.dto.form.category;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>서브 카테고리 수정 폼.</p>
 */
public class UpdateSubCategoryForm extends BaseForm {

    private long subCategoryIdx = 0;

    private String subCategoryNameKr = "";

    private String subCategoryNameJp = "";

    /**
     * <p>서브 카테고리 인덱스를 반환한다.</p>
     *
     * @return 서브 카테고리 인덱스
     */
    public long getSubCategoryIdx() {
        return subCategoryIdx;
    }

    /**
     * <p>서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param subCategoryIdx 서브 카테고리 인덱스
     */
    public void setSubCategoryIdx(long subCategoryIdx) {
        this.subCategoryIdx = subCategoryIdx;
    }

    /**
     * <p>서브 카테고리 이름(한국어)을 반환한다.</p>
     *
     * @return 서브 카테고리 이름(한국어)
     */
    public String getSubCategoryNameKr() {
        return subCategoryNameKr;
    }

    /**
     * <p>서브 카테고리 이름(한국어)을 설정한다.</p>
     *
     * @param subCategoryNameKr 서브 카테고리 이름(한국어)
     */
    public void setSubCategoryNameKr(String subCategoryNameKr) {
        this.subCategoryNameKr = subCategoryNameKr;
    }

    /**
     * <p>서브 카테고리 이름(일본어)을 반환한다.</p>
     *
     * @return 서브 카테고리 이름(일본어)
     */
    public String getSubCategoryNameJp() {
        return subCategoryNameJp;
    }

    /**
     * <p>서브 카테고리 이름(일본어)을 설정한다.</p>
     *
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     */
    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }


}
