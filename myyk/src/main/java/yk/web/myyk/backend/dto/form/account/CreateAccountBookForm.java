package yk.web.myyk.backend.dto.form.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;

/**
 * <p>가계부 생성 폼.</p>
 */
public class CreateAccountBookForm extends BaseForm {

    /**
     * <p>가계부 이름(한국어).</p>
     */
    private String accountBookNameKo = "";

    /**
     * <p>가계부 이름(일본어).</p>
     */
    private String accountBookNameJp = "";

    /**
     * <p>세금포함 여부.</p>
     */
    private boolean taxInclude = false;

    /**
     * <p>세율.</p>
     */
    private double taxRate = 0;

    /**
     * <p>통화단위.</p>
     */
    private String currency = "";

    /**
     * <p>읽기 권한 목록.</p>
     */
    private List<Long> readAuthList = new ArrayList<>();

    /**
     * <p>쓰기 권한 목록.</p>
     */
    private List<Long> writeAuthList = new ArrayList<>();

    /**
     * <p>가계부 이름(한국어)을 반환한다.</p>
     *
     * @return 가계부 이름(한국어)
     */
    public String getAccountBookNameKo() {
        return accountBookNameKo;
    }

    /**
     * <p>가계부 이름(한국어)을 설정한다.</p>
     *
     * @param accountBookNameKo 가계부 이름(한국어)
     */
    public void setAccountBookNameKo(String accountBookNameKo) {
        this.accountBookNameKo = accountBookNameKo;
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
     * <p>가계부 이름(일본어)을 설정한다.</p>
     *
     * @param accountBookNameJp 가계부 이름(일본어)
     */
    public void setAccountBookNameJp(String accountBookNameJp) {
        this.accountBookNameJp = accountBookNameJp;
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
     * <p>세금 포함 여부를 설정한다.</p>
     *
     * @param taxInclude 세금 포함 여부
     */
    public void setTaxInclude(boolean taxInclude) {
        this.taxInclude = taxInclude;
    }

    /**
     * <p>세율을 반환한다.</p>
     *
     * @return 세율
     */
    public TaxRate getTaxRate() {
        return TaxRate.getTaxRate(taxRate);
    }

    /**
     * <p>세율을 설정한다.</p>
     *
     * @param taxRate 세율
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * <p>통화단위를 반환한다.</p>
     *
     * @return 통화단위
     */
    public Currency getCurrency() {
        return Currency.getCurrency(currency);
    }

    /**
     * <p>통화단위를 설정한다.</p>
     *
     * @param currency 통화단위
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * <p>읽기 권한 리스트를 반환한다.</p>
     *
     * @return 읽기 권한 리스트
     */
    public List<Long> getReadAuthList() {
        return readAuthList;
    }

    /**
     * <p>읽기 권한 리스트를 설정한다.</p>
     *
     * @param readAuth 읽기 권한 리스트
     */
    public void setReadAuthList(List<Long> readAuthList) {
        this.readAuthList = readAuthList;
    }

    /**
     * <p>쓰기 권한 리스트를 반환한다.</p>
     *
     * @return 쓰기 권한 리스트
     */
    public List<Long> getWriteAuthList() {
        return writeAuthList;
    }

    /**
     * <p>쓰기 권한 리스트를 설정한다.</p>
     *
     * @param writeAuth 쓰기 권한 리스트
     */
    public void setWriteAuthList(List<Long> writeAuthList) {
        this.writeAuthList = writeAuthList;
    }
}
