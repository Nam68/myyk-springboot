package yk.web.myyk.backend.entity.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntity;

@Entity
@Table(name = "SUB_CATEGORY_TBL")
public class SubCategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_CATEGORY_IDX")
    private Long subCategoryIdx;

    @Column(name = "SUB_CATEGORY_NAME_KR")
    private String subCategoryNameKr;

    @Column(name = "SUB_CATEGORY_NAME_JP")
    private String subCategoryNameJp;

    @Column(name = "SORT_NO")
    private int sortNo;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CategoryEntity.class)
    private CategoryEntity category;

    @Deprecated
    public SubCategoryEntity() {
        // nop
    }

    /**
     * <p>생성자.</p>
     *
     * @param subCategoryNameKr 서브 카테고리 이름(한국어)
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     * @param sortNo 정렬번호
     */
    public SubCategoryEntity(String subCategoryNameKr, String subCategoryNameJp, int sortNo, CategoryEntity category) {
        setSubCategoryNameKr(subCategoryNameKr);
        setSubCategoryNameJp(subCategoryNameJp);
        setSortNo(sortNo);
        setCategory(category);
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
    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    /**
     * <p>카테고리를 설정한다.</p>
     *
     * @param category 카테고리
     */
    public void setSubCategory(CategoryEntity category) {
        this.category = category;
    }

    /**
     * <p>정렬 번호를 반환한다.</p>
     *
     * @return 정렬 번호
     */
    public int getSortNo() {
        return sortNo;
    }

    /**
     * <p>정렬 번호를 설정한다.</p>
     *
     * @param sortNo 정렬 번호
     */
    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }
}
