package yk.web.myyk.backend.dto.holder.account;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>가계부 카테고리 설정용 홀더.</p>
 */
public class CreateAccountBookCategoryHolder extends BaseHolder {

    /**
     * <p>가계부 인덱스.</p>
     */
    private long accountBookIdx;

    /**
     * <p>가계부 이름(한국어).</p>
     */
    private String accountBookNameKr;

    /**
     * <p>가계부 이름(일본어).</p>
     */
    private String accountBookNameJp;

    /**
     * <p>생성자 : 초기화면용</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public CreateAccountBookCategoryHolder(AccountBookDTO dto) {
        this.accountBookIdx = dto.getAccountBookIdx();
        this.accountBookNameKr = dto.getAccountBookNameKr();
        this.accountBookNameJp = dto.getAccountBookNameJp();
    }

    /**
     * <p>가계부 인덱스를 반환한다.</p>
     *
     * @return 가계부 인덱스
     */
    public long getAccountBookIdx() {
        return accountBookIdx;
    }

    /**
     * <p>가계부 이름(한국어)를 반환한다.</p>
     *
     * @return 가계부 이름(한국어)
     */
    public String getAccountBookNameKr() {
        return accountBookNameKr;
    }

    /**
     * <p>가계부 이름(일본어)를 반환한다.</p>
     *
     * @return 가계부 이름(일본어)
     */
    public String getAccountBookNameJp() {
        return accountBookNameJp;
    }
}
