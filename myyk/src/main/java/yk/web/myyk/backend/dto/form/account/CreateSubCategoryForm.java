package yk.web.myyk.backend.dto.form.account;

import yk.web.myyk.backend.dto.form.BaseForm;

public class CreateSubCategoryForm extends BaseForm {

    private long categoryIdx = 0;

    private String subCategoryNameKo = "";

    private String subCategoryNameJp = "";

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @return 카테고리 인덱스
     */
    public long getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(한국어)
     */
    public String getSubCategoryNameKo() {
        return subCategoryNameKo;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param subCategoryNameKo 서브 카테고리 이름(한국어)
     */
    public void setSubCategoryNameKo(String subCategoryNameKo) {
        this.subCategoryNameKo = subCategoryNameKo;
    }

    /**
     * <p>서브 카테고리 이름(일본어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(일본어)
     */
    public String getSubCategoryNameJp() {
        return subCategoryNameJp;
    }

    /**
     * <p>서브 카테고리 이름(일본어)를 설정한다.</p>
     *
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     */
    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }
}
