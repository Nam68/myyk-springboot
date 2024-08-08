package yk.web.myyk.backend.dto.form.category;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>{@link SearchSubCategory}의 폼.</p>
 */
public class SearchSubCategoryForm extends BaseForm {

    private long categoryIdx = 0;

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @return 카테고리 인덱스
     */
    public long getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }
}
