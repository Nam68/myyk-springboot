package yk.web.myyk.backend.dto.holder.category;

import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>서브 카테고리 검색결과 홀더.</p>
 */
public class FindSubCategoryHolder extends BaseHolder {

    private String subCategoryNameKr;

    private String subCategoryNameJp;

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
     * 서브 카테고리 이름(일본어)을 설정한다.
     *
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     */
    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }
}
