package yk.web.myyk.backend.dto.form.account;

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
}
