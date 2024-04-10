package yk.web.myyk.backend.dto.form.account;

import yk.web.myyk.backend.dto.form.BaseForm;

public class CreateCategoryForm extends BaseForm {
    /**
     * <p>카테고리 이름(한국어).</p>
     */
    private String categoryNameKo = "";

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

    /**
     * <p>카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 카테고리 이름(한국어)
     */
    public String getCategoryNameKo() {
        return categoryNameKo;
    }

    /**
     * <p>카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param categoryNameKo 카테고리 이름(한국어)
     */
    public void setCategoryNameKo(String categoryNameKo) {
        this.categoryNameKo = categoryNameKo;
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
