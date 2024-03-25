package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yk.web.myyk.backend.dto.MemberDto;
import yk.web.myyk.backend.dto.form.account.CreateAccountForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.Region;
import yk.web.myyk.util.enumerated.TaxRate;

public class CreateAccountHolder extends BaseHolder {

    /**
     * <p>가계부 이름.</p>
     */
    private String accountName = "";

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
     * <p>읽기 권한 목록.</p>
     */
    private Map<Long, Boolean> readAuthMap = new HashMap<>();

    /**
     * <p>쓰기 권한 목록.</p>
     */
    private Map<Long, Boolean> writeAuthMap = new HashMap<>();

    /**
     * <p>회원 리스트(본인 제외).</p>
     */
    private List<AccountMemberHolder> memberList = new ArrayList<>();

    /**
     * <p>생성자.</p>
     *
     * @param memberDtoList 회원 리스트(본인 제외)
     */
    public CreateAccountHolder(List<MemberDto> memberDtoList) {
        for (MemberDto dto : memberDtoList) {
            memberList.add(new AccountMemberHolder(dto));
        }
    }

    /**
     * <p>생성자.</p>
     *
     * @param memberDtoList 회원 리스트(본인 제외)
     */
    public CreateAccountHolder(LoginInfo loginInfo, List<MemberDto> memberDtoList) {
        this(memberDtoList);
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
     * @param memberDtoList 회원 리스트(본인 제외)
     * @param form 폼
     */
    public CreateAccountHolder(List<MemberDto> memberDtoList, CreateAccountForm form) {
        this(memberDtoList);
        this.accountName = form.getAccountName();
        this.taxInclude = form.isTaxInclude();
        this.taxRate = form.getTaxRate();
        this.currency = form.getCurrency();

        for (long memberIdx : form.getReadAuthList()) {
            readAuthMap.put(memberIdx, true);
        }
        for (long memberIdx : form.getWriteAuthList()) {
            writeAuthMap.put(memberIdx, true);
        }
    }

    /**
     * <p>가계부 이름을 반환한다.</p>
     *
     * @return 가계부 이름
     */
    public String getAccountName() {
        return accountName;
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

    /**
     * <p>읽기권한 리스트를 반환한다.</p>
     *
     * @return 읽기권한 맵
     */
    public Map<Long, Boolean> getReadAuthMap() {
        return readAuthMap;
    }

    /**
     * <p>쓰기권한 리스트를 반환한다.</p>
     *
     * @return 쓰기권한 맵
     */
    public Map<Long, Boolean> getWriteAuthMap() {
        return writeAuthMap;
    }

    /**
     * <p>회원 리스트(본인 제외)를 반환한다.</p>
     *
     * @return 회원 리스트(본인 제외)
     */
    public List<AccountMemberHolder> getMemberList() {
        return memberList;
    }
}
