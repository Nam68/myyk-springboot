package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.account.SubCategoryEntity;

/**
 * <p>서브 카테고리 DTO.</p>
 */
public class SubCategoryDTO extends BaseDTO {

    private long categoryIdx;

    private long subCategoryIdx;

    private String subCategoryNameKo;

    private String subCategoryNameJp;

    private int sortNo;

    /**
     * <p>생성자.</p>
     *
     * @deprecated 하이버네이트용
     */
    @Deprecated
    public SubCategoryDTO() {
        // nop
    }

    /**
     * <p>생성자.</p>
     *
     * @param entity 엔티티
     */
    public SubCategoryDTO(SubCategoryEntity entity) {
        setSubCategoryIdx(entity.getSubCategoryIdx());
        setSubCategoryNameKo(entity.getSubCategoryNameKo());
        setSubCategoryNameJp(entity.getSubCategoryNameJp());
        setSortNo(entity.getSortNo());
    }

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @return 카테고리 인덱스
     */
    public long getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    /**
     * <p>서브 카테고리 인덱스를 반환한다.</p>
     *
     * @return 서브 카테고리 인덱스
     */
    public long getSubCategoryIdx() {
        return subCategoryIdx;
    }

    /**
     * <p>서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param subCategoryIdx 서브 카테고리 인덱스
     */
    public void setSubCategoryIdx(long subCategoryIdx) {
        this.subCategoryIdx = subCategoryIdx;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(한국어)
     */
    public String getSubCategoryNameKo() {
        return subCategoryNameKo;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param subCategoryNameKo 서브 카테고리 이름(한국어)
     */
    public void setSubCategoryNameKo(String subCategoryNameKo) {
        this.subCategoryNameKo = subCategoryNameKo;
    }

    /**
     * <p>서브 카테고리 이름(일본어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(일본어)
     */
    public String getSubCategoryNameJp() {
        return subCategoryNameJp;
    }

    /**
     * <p>서브 카테고리 이름(일본어)를 설정한다.</p>
     *
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     */
    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }

    /**
     * <p>정렬순서를 반환한다.</p>
     *
     * @return 정렬순서
     */
    public int getSortNo() {
        return sortNo;
    }

    /**
     * <p>정렬순서를 설정한다.</p>
     *
     * @param sortNo 정렬순서
     */
    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }
}
