package yk.web.myyk.backend.dto.form.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>가계부 카테고리 설정용 폼.</p>
 */
public class CreateAccountBookCategoryForm extends BaseForm {

    /**
     * <p>가계부 인덱스.</p>
     */
    private long accountBookIdx = 0;

    /**
     * <p>카테고리 인덱스.</p>
     */
    private List<Long> categoryIdx = new ArrayList<>();

    /**
     * <p>서브 카테고리 인덱스.</p>
     */
    private List<Long> subCategoryIdx = new ArrayList<>();

    /**
     * <p>가계부 인덱스를 반환한다.</p>
     *
     * @return 가계부 인덱스
     */
    public long getAccountBookIdx() {
        return accountBookIdx;
    }

    /**
     * <p>가계부 인덱스를 설정한다.</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public void setAccountBookIdx(long accountBookIdx) {
        this.accountBookIdx = accountBookIdx;
    }

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @return 기본 카테고리 인덱스
     */
    public List<Long> getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(List<Long> categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    /**
     * <p>서브 카테고리 인덱스를 반환한다.</p>
     *
     * @return 서브 카테고리 인덱스
     */
    public List<Long> getSubCategoryIdx() {
        return subCategoryIdx;
    }

    /**
     * <p>서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param subCategoryIdx 서브 카테고리 인덱스
     */
    public void setSubCategoryIdx(List<Long> subCategoryIdx) {
        this.subCategoryIdx = subCategoryIdx;
    }
}
