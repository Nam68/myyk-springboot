package yk.web.myyk.backend.entity.account;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import yk.web.myyk.backend.entity.BaseEntityWithTime;

public class SubCategoryEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_CATEGORY_IDX")
    private Long subCategoryIdx;

    @Column(name = "SUB_CATEGORY_NAME_KR")
    private String subCategoryNameKr;

    @Column(name = "SUB_CATEGORY_NAME_JP")
    private String subCategoryNameJp;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CategoryEntity.class)
    @JoinColumn(name = "CATEGORY_IDX")
    private CategoryEntity category;

    @Deprecated
    public SubCategoryEntity() {
        // nop
    }

    /**
     * <p>서브 카테고리 인덱스를 반환한다.</p>
     *
     * @return 서브 카테고리 인덱스
     */
    public Long getSubCategoryIdx() {
        return subCategoryIdx;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(한국어)
     */
    public String getSubCategoryNameKr() {
        return subCategoryNameKr;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param subCategoryNameKr 서브 카테고리 이름(한국어)
     */
    public void setSubCategoryNameKr(String subCategoryNameKr) {
        this.subCategoryNameKr = subCategoryNameKr;
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
     * <p>카테고리를 반환한다.</p>
     *
     * @return 카테고리
     */
    public CategoryEntity getCategory() {
        return category;
    }

    /**
     * <p>카테고리를 설정한다.</p>
     *
     * @param category 카테고리
     */
    private void setSubCategory(CategoryEntity category) {
        this.category = category;
    }
}
