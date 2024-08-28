package yk.web.myyk.backend.dto.holder.account;

import yk.web.myyk.backend.dto.form.account.CreateAccountBookForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>가계부 정보 생성 홀더.</p>
 */
public class CreateAccountBookInfoHolder extends BaseHolder {

    /**
     * <p>가계부 이름(한국어).</p>
     */
    private String accountBookNameKr = "";

    /**
     * <p>가계부 이름(일본어).</p>
     */
    private String accountBookNameJp = "";

    /**
     * <p>통화단위.</p>
     */
    private Currency currency = Currency.WON;

    /**
     * <p>생성자.</p>
     *
     * @param loginInfo 로그인 정보
     */
    public CreateAccountBookInfoHolder(LoginInfo loginInfo) {

        Region region = loginInfo.getRegion();
        switch (region) {
            case KOREA:
                currency = Currency.WON;
                break;
            case JAPAN:
                currency = Currency.YEN;
                break;
        }
    }

    /**
     * <p>생성자.</p>
     *
     * @param loginInfo 로그인 정보
     * @param form 가계부 정보 생성 폼
     */
    public CreateAccountBookInfoHolder(LoginInfo loginInfo, CreateAccountBookForm form) {
        this(loginInfo);
        this.accountBookNameKr = form.getAccountBookNameKr();
        this.accountBookNameJp = form.getAccountBookNameJp();
        this.currency = form.getCurrency();
    }

    /**
     * <p>가계부 이름(한국어)을 반환한다.</p>
     *
     * @return 가계부 이름(한국어)
     */
    public String getAccountBookNameKr() {
        return accountBookNameKr;
    }

    /**
     * <p>가계부 이름(일본어)을 반환한다.</p>
     *
     * @return 가계부 이름(일본어)
     */
    public String getAccountBookNameJp() {
        return accountBookNameJp;
    }

    /**
     * <p>통화단위를 반환한다.</p>
     *
     * @return 통화단위
     */
    public Currency getCurrency() {
        return currency;
    }
}
