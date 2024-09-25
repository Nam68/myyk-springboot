package yk.web.myyk.backend.dto.form.account;

import java.util.List;

import yk.web.myyk.backend.dto.form.BaseForm;

/**
 * <p>가계부 카테고리 설정용 폼.</p>
 */
public class CreateAccountBookCategoryForm extends BaseForm {

    /**
     * <p>가계부 인덱스.</p>
     */
    private long accountBookIdx;

    /**
     * <p>기본 카테고리 인덱스.</p>
     */
    private List<Long> basicCategoryIdx;

    /**
     * <p>기본 서브 카테고리 인덱스.</p>
     */
    private List<Long> basicSubCategoryIdx;

    /**
     * <p>생성된 카테고리 인덱스.</p>
     */
    private List<Long> createdCategoryIdx;

    /**
     * <p>생성된 서브 카테고리 인덱스.</p>
     */
    private List<Long> createdSubCategoryIdx;

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
     * <p>기본 카테고리 인덱스를 반환한다.</p>
     *
     * @return 기본 카테고리 인덱스
     */
    public List<Long> getBasicCategoryIdx() {
        return basicCategoryIdx;
    }

    /**
     * <p>기본 카테고리 인덱스를 설정한다.</p>
     *
     * @param basicCategoryIdx 기본 카테고리 인덱스
     */
    public void setBasicCategoryIdx(List<Long> basicCategoryIdx) {
        this.basicCategoryIdx = basicCategoryIdx;
    }

    /**
     * <p>기본 서브 카테고리 인덱스를 반환한다.</p>
     *
     * @return 기본 서브 카테고리 인덱스
     */
    public List<Long> getBasicSubCategoryIdx() {
        return basicSubCategoryIdx;
    }

    /**
     * <p>기본 서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param basicSubCategoryIdx 기본 서브 카테고리 인덱스
     */
    public void setBasicSubCategoryIdx(List<Long> basicSubCategoryIdx) {
        this.basicSubCategoryIdx = basicSubCategoryIdx;
    }

    /**
     * <p>생성된 카테고리 인덱스를 반환한다.</p>
     *
     * @return 생성된 카테고리 인덱스
     */
    public List<Long> getCreatedCategoryIdx() {
        return createdCategoryIdx;
    }

    /**
     * <p>생성된 카테고리 인덱스를 설정한다.</p>
     *
     * @param createdCategoryIdx 생성된 카테고리 인덱스
     */
    public void setCreatedCategoryIdx(List<Long> createdCategoryIdx) {
        this.createdCategoryIdx = createdCategoryIdx;
    }

    /**
     * <p>생성된 서브 카테고리 인덱스를 반환한다.</p>
     *
     * @return 생성된 서브 카테고리 인덱스
     */
    public List<Long> getCreatedSubCategoryIdx() {
        return createdSubCategoryIdx;
    }

    /**
     * <p>생성된 서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param createdSubCategoryIdx 생성된 서브 카테고리 인덱스
     */
    public void setCreatedSubCategoryIdx(List<Long> createdSubCategoryIdx) {
        this.createdSubCategoryIdx = createdSubCategoryIdx;
    }
}
