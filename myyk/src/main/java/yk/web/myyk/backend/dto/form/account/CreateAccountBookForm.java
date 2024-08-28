package yk.web.myyk.backend.dto.form.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.form.BaseForm;
import yk.web.myyk.util.enumerated.Currency;

/**
 * <p>가계부 생성 폼.</p>
 */
public class CreateAccountBookForm extends BaseForm {

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
    public String getAccountBookNameKr() {
        return accountBookNameKr;
    }

    /**
     * <p>가계부 이름(한국어)을 설정한다.</p>
     *
     * @param accountBookNameKr 가계부 이름(한국어)
     */
    public void setAccountBookNameKr(String accountBookNameKr) {
        this.accountBookNameKr = accountBookNameKr;
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
