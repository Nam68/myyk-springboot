package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private long accountBookIdx = 0;

    /**
     * <p>가계부 이름(한국어).</p>
     */
    private String accountBookNameKr = "";

    /**
     * <p>가계부 이름(일본어).</p>
     */
    private String accountBookNameJp = "";

    /**
     * <p>기본 카테고리.</p>
     */
    private List<CategoryDTO> basicCategoryList = new ArrayList<>();

    /**
     * <p>회원 카테고리.</p>
     */
    private List<CategoryDTO> createdCategoryList = new ArrayList<>();

    /**
     * <p>선택된 카테고리.</p>
     */
    private Map<String, Boolean> selectedCategory = new HashMap<>();

    /**
     * <p>선택된 서브 카테고리.</p>
     */
    private Map<String, Boolean> selectedSubCategory = new HashMap<>();

    /**
     * <p>생성자 : 초기화면용</p>
     */
    public CreateAccountBookCategoryHolder(AccountBookDTO dto, List<CategoryDTO> basicCategoryList, List<CategoryDTO> createdCategoryList) {
        this.accountBookIdx = dto.getAccountBookIdx();
        this.accountBookNameKr = dto.getAccountBookNameKr();
        this.accountBookNameJp = dto.getAccountBookNameJp();
        this.basicCategoryList = basicCategoryList;
        this.createdCategoryList = createdCategoryList;
    }

    /**
     * <p>생성자.</p>
     *
     * @param dto
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

    /**
     * <p>기본 카테고리 리스트를 반환한다.</p>
     *
     * @return 기본 카테고리
     */
    public List<CategoryDTO> getBasicCategoryList() {
        return basicCategoryList;
    }

    /**
     * <p>생성된 카테고리 리스트를 반환한다.</p>
     *
     * @return 생성된 카테고리
     */
    public List<CategoryDTO> getCreatedCategoryList() {
        return createdCategoryList;
    }

    /**
     * <p>선택된 카테고리를 반환한다.</p>
     *
     * @return 선택된 카테고리
     */
    public Map<String, Boolean> getSelectedCategory() {
        return selectedCategory;
    }

    /**
     * <p>선택된 카테고리를 설정한다.</p>
     *
     * @param selectedCategory 선택된 카테고리
     */
    public void setSelectedCategory(Map<String, Boolean> selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    /**
     * <p>선택된 기본 서브 카테고리를 반환한다.</p>
     *
     * @return 선택된 기본 서브 카테고리
     */
    public Map<String, Boolean> getSelectedSubCategory() {
        return selectedSubCategory;
    }

    /**
     * <p>선택된 기본 서브 카테고리를 설정한다.</p>
     *
     * @param selectedCategory 선택된 기본 서브 카테고리
     */
    public void setSelectedSubCategory(Map<String, Boolean> selectedSubCategory) {
        this.selectedSubCategory = selectedSubCategory;
    }
}
