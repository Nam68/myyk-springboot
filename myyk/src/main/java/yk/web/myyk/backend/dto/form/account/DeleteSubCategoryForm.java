package yk.web.myyk.backend.dto.form.account;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>서브 카테고리 삭제 폼.</p>
 */
public class DeleteSubCategoryForm extends BaseForm {

    private long subCategoryIdx = 0;

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
}
