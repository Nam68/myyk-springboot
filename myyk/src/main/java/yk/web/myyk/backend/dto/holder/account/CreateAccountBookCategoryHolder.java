package yk.web.myyk.backend.dto.holder.account;

import java.util.List;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.CategoryDTO;
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
     * <p>기본 카테고리.</p>
     */
    private List<CategoryDTO> basicCategoryList;

    /**
     * <p>회원 카테고리.</p>
     */
    private List<CategoryDTO> memberCategoryList;

    /**
     * <p>생성자 : 초기화면용</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public CreateAccountBookCategoryHolder(AccountBookDTO dto, List<CategoryDTO> basicCategoryList, List<CategoryDTO> memberCategoryList) {
        this.accountBookIdx = dto.getAccountBookIdx();
        this.accountBookNameKr = dto.getAccountBookNameKr();
        this.accountBookNameJp = dto.getAccountBookNameJp();
        this.basicCategoryList = basicCategoryList;
        this.memberCategoryList = memberCategoryList;
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

    /**
     * <p>기본 카테고리 리스트를 반환한다.</p>
     *
     * @return 기본 카테고리
     */
    public List<CategoryDTO> getBasicCategoryList() {
        return basicCategoryList;
    }

    /**
     * <p>회원 카테고리 리스트를 반환한다.</p>
     *
     * @return 회원 카테고리
     */
    public List<CategoryDTO> getMemberCategoryList() {
        return memberCategoryList;
    }
}
