package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yk.web.myyk.backend.dto.AccountBookDTO;
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
     * <p>가계부 인덱스</p>
     */
    private long accountBookIdx;

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
    private Map<String, MemberDTO> readAuthMap = new HashMap<>();

    /**
     * <p>쓰기 권한 목록.</p>
     */
    private Map<String, MemberDTO> writeAuthMap = new HashMap<>();

    /**
     * <p>완료화면용 홀더.</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public CreateAccountBookHolder(long accountBookIdx) {
        this.accountBookIdx = accountBookIdx;
    }

    /**
     * <p>생성자.</p>
     *
     * @param form 폼
     */
    private CreateAccountBookHolder(CreateAccountBookForm form) {
        this.accountBookNameKr = form.getAccountBookNameKr();
        this.accountBookNameJp = form.getAccountBookNameJp();
        this.currency = form.getCurrency();
    }

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
     * @param readAuthList 읽기 권한 리스트
     * @param writeAuthList 쓰기 권한 리스트
     */
    public CreateAccountBookHolder(CreateAccountBookForm form, List<MemberDTO> readAuthList, List<MemberDTO> writeAuthList) {
        this(form);

        for (MemberDTO readAuth : readAuthList) {
            // 프리마커에서는 키에 문자열이 들어가야만 에러가 나지 않기 때문
            String idx = String.valueOf(readAuth.getMemberIdx());
            readAuthMap.put(idx, readAuth);
        }
        for (MemberDTO writeAuth : writeAuthList) {
            // 프리마커에서는 키에 문자열이 들어가야만 에러가 나지 않기 때문
            String idx = String.valueOf(writeAuth.getMemberIdx());
            writeAuthMap.put(idx, writeAuth);
        }
    }

    public CreateAccountBookHolder(AccountBookDTO dto) {
        this.accountBookNameKr = dto.getAccountBookNameKr();
        this.accountBookNameJp = dto.getAccountBookNameJp();
        this.currency = dto.getCurrency();
    }

    /**
     * <p>생성자.</p>
     *
     * @param memberList 회원 리스트
     * @param form 가계부 정보 생성 폼
     */
    public CreateAccountBookHolder(List<MemberDTO> memberList, CreateAccountBookForm form) {
        this(form);
        this.memberList = memberList;

        for (long readAuthIdx : form.getReadAuthList()) {
            MemberDTO pseudoDto = new MemberDTO(readAuthIdx);
            readAuthMap.put(String.valueOf(readAuthIdx), pseudoDto);
        }
        for (long writeAuthIdx : form.getWriteAuthList()) {
            MemberDTO pseudoDto = new MemberDTO(writeAuthIdx);
            writeAuthMap.put(String.valueOf(writeAuthIdx), pseudoDto);
        }
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
    public Map<String, MemberDTO> getReadAuthMap() {
        return readAuthMap;
    }

    /**
     * <p>쓰기 권한 리스트를 반환한다.</p>
     *
     * @return 쓰기 권한 리스트
     */
    public Map<String, MemberDTO> getWriteAuthMap() {
        return writeAuthMap;
    }
}
