package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yk.web.myyk.backend.dto.MemberDTO;
import yk.web.myyk.backend.dto.form.account.CreateAccountBookForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.enumerated.Currency;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>가계부 생성 홀더.</p>
 */
public class CreateAccountBookHolder extends BaseHolder {

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
     * <p>회원 리스트.</p>
     */
    private List<MemberDTO> memberList = new ArrayList<>();

    /**
     * <p>읽기 권한 목록.</p>
     */
    private Map<Long, MemberDTO> readAuthMap = new HashMap<>();

    /**
     * <p>쓰기 권한 목록.</p>
     */
    private Map<Long, MemberDTO> writeAuthMap = new HashMap<>();

    // 참고
    // <#list map?keys as key>
    //     ${may[key]}
    // </#list>

    /**
     * <p>생성자.</p>
     *
     * @param loginInfo 로그인 정보
     * @param memberList 회원 리스트
     */
    public CreateAccountBookHolder(LoginInfo loginInfo, List<MemberDTO> memberList) {

        this.memberList = memberList;

        Region region = loginInfo.getRegion();
        switch (region) {
            case KOREA: currency = Currency.WON; break;
            case JAPAN: currency = Currency.YEN; break;
        }
    }

    /**
     * <p>생성자.</p>
     *
     * @param form 가계부 정보 생성 폼
     */
    public CreateAccountBookHolder(CreateAccountBookForm form, List<MemberDTO> readAuthList, List<MemberDTO> writeAuthList) {
        this.accountBookNameKr = form.getAccountBookNameKr();
        this.accountBookNameJp = form.getAccountBookNameJp();
        this.currency = form.getCurrency();

        for (MemberDTO readAuth : readAuthList) {
            readAuthMap.put(readAuth.getMemberIdx(), readAuth);
        }

        for (MemberDTO writeAuth : writeAuthList) {
            writeAuthMap.put(writeAuth.getMemberIdx(), writeAuth);
        }
    }

    /**
     * <p>생성자.</p>
     *
     * @param memberList 회원 리스트
     * @param form 가계부 정보 생성 폼
     */
    public CreateAccountBookHolder(List<MemberDTO> memberList, CreateAccountBookForm form, List<MemberDTO> readAuthList, List<MemberDTO> writeAuthList) {
        this(form, readAuthList, writeAuthList);
        this.memberList = memberList;
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

    /**
     * <p>회원 리스트를 반환한다.</p>
     *
     * @return
     */
    public List<MemberDTO> getMemberList() {
        return memberList;
    }

    /**
     * <p>읽기 권한 리스트를 반환한다.</p>
     *
     * @return 읽기 권한 리스트
     */
    public Map<Long, MemberDTO> getReadAuthMap() {
        return readAuthMap;
    }

    /**
     * <p>쓰기 권한 리스트를 반환한다.</p>
     *
     * @return 쓰기 권한 리스트
     */
    public Map<Long, MemberDTO> getWriteAuthList() {
        return writeAuthMap;
    }
}
