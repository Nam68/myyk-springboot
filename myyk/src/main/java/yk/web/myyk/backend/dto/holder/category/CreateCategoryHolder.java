package yk.web.myyk.backend.dto.holder.category;

import yk.web.myyk.backend.dto.form.category.CreateCategoryForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>카테고리 생성 홀더.</p>
 */
public class CreateCategoryHolder extends BaseHolder {

    /**
     * <p>카테고리 인덱스.</p>
     */
    private long categoryIdx = 0;

    /**
     * <p>카테고리 이름(한국어).</p>
     */
    private String categoryNameKr = "";

    /**
     * <p>카테고리 이름(일본어).</p>
     */
    private String categoryNameJp = "";

    /**
     * <p>카테고리 색.</p>
     */
    private String categoryColor = "";

    /**
     * <p>카테고리 아이콘.</p>
     */
    private String categoryIcon = "";

    public CreateCategoryHolder() {
        // nop
    }

    public CreateCategoryHolder(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public CreateCategoryHolder(CreateCategoryForm form) {
        setCategoryNameKr(form.getCategoryNameKr());
        setCategoryNameJp(form.getCategoryNameJp());
        setCategoryColor(form.getCategoryColor());
        setCategoryIcon(form.getCategoryIcon());
    }

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @return 카테고리 인덱스
     */
    public long getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 카테고리 이름(한국어)
     */
    public String getCategoryNameKr() {
        return categoryNameKr;
    }

    /**
     * <p>카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param categoryNameKr 카테고리 이름(한국어)
     */
    public void setCategoryNameKr(String categoryNameKr) {
        this.categoryNameKr = categoryNameKr;
    }

    /**
     * <p>카테고리 이름(일본어)를 반환한다.</p>
     *
     * @return 카테고리 이름(일본어)
     */
    public String getCategoryNameJp() {
        return categoryNameJp;
    }

    /**
     * <p>카테고리 이름(일본어)를 설정한다.</p>
     *
     * @param categoryNameJp 카테고리 이름(일본어)
     */
    public void setCategoryNameJp(String categoryNameJp) {
        this.categoryNameJp = categoryNameJp;
    }

    /**
     * <p>카테고리 색을 반환한다.</p>
     *
     * @return 카테고리 색
     */
    public String getCategoryColor() {
        return categoryColor;
    }

    /**
     * <p>카테고리 색을 설정한다.</p>
     *
     * @param categoryColor 카테고리 색
     */
    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    /**
     * <p>카테고리 아이콘을 반환한다.</p>
     *
     * @return 카테고리 아이콘
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * <p>카테고리 아이콘을 설정한다.</p>
     *
     * @param categoryIcon 카테고리 아이콘
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }
}
