package yk.web.myyk.backend.dto.holder.account;

import yk.web.myyk.backend.dto.form.account.CreateAccountBookInfoForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.enumerated.TaxRate;

/**
 * <p>가계부 정보 생성 홀더.</p>
 */
public class CreateAccountBookInfoHolder extends BaseHolder {

    /**
     * <p>가계부 이름(한국어).</p>
     */
    private String accountBookNameKo = "";

    /**
     * <p>가계부 이름(일본어).</p>
     */
    private String accountBookNameJp = "";

    /**
     * <p>세금 포함 여부.</p>
     */
    private boolean taxInclude = false;

    /**
     * <p>세율.</p>
     */
    private TaxRate taxRate = TaxRate.LOW;

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
                taxRate = TaxRate.HIGH;
                currency = Currency.WON;
                break;
            case JAPAN:
                taxRate = TaxRate.LOW;
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
    public CreateAccountBookInfoHolder(LoginInfo loginInfo, CreateAccountBookInfoForm form) {
        this(loginInfo);
        this.accountBookNameKo = form.getAccountBookNameKo();
        this.accountBookNameJp = form.getAccountBookNameJp();
        this.taxInclude = form.isTaxInclude();
        this.taxRate = form.getTaxRate();
        this.currency = form.getCurrency();
    }

    /**
     * <p>가계부 이름(한국어)을 반환한다.</p>
     *
     * @return 가계부 이름(한국어)
     */
    public String getAccountBookNameKo() {
        return accountBookNameKo;
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
     * <p>세금 포함 여부를 반환한다.</p>
     *
     * @return 세금 포함 여부
     */
    public boolean isTaxInclude() {
        return taxInclude;
    }

    /**
     * <p>세율을 반환한다.</p>
     *
     * @return 세율
     */
    public TaxRate getTaxRate() {
        return taxRate;
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
