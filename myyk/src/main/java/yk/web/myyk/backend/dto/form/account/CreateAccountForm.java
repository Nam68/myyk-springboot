package yk.web.myyk.backend.dto.form.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.TaxRate;

/**
 * <p>가계부 생성 폼.</p>
 */
public class CreateAccountForm extends BaseForm {

    /**
     * <p>가계부 이름.</p>
     */
    private String accountName = "";

    /**
     * <p>세금 포함 여부.</p>
     */
    private boolean taxIncluded = false;

    /**
     * <p>세율.</p>
     */
    private double tax = 0;

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
     * <p>가계부 이름을 반환한다.</p>
     * 
     * @return 가계부 이름
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * <p>가계부 이름을 설정한다.</p>
     * 
     * @param accountName 가계부 이름
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * <p>세금 포함 여부를 반환한다.</p>
     * 
     * @return 세금 포함 여부
     */
    public boolean isTaxIncluded() {
        return taxIncluded;
    }

    /**
     * <p>세금 포함 여부를 설정한다.</p>
     * 
     * @param taxIncluded 세금 포함 여부
     */
    public void setTaxIncluded(boolean taxIncluded) {
        this.taxIncluded = taxIncluded;
    }

    /**
     * <p>세율을 반환한다.</p>
     * 
     * @return 세율
     */
    public TaxRate getTax() {
        return TaxRate.getTaxRate(tax);
    }

    /**
     * <p>세율을 설정한다.</p>
     * 
     * @param tax 세율
     */
    public void setTax(double tax) {
        this.tax = tax;
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
