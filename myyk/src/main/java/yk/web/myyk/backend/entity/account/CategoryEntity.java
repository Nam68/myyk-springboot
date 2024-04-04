package yk.web.myyk.backend.entity.account;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntityWithTime;
import yk.web.myyk.backend.entity.member.MemberEntity;

@Entity
@Table(name = "CATEGORY_ENTITY")
public class CategoryEntity extends BaseEntityWithTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_IDX")
    private Long categoryIdx;

    @Column(name = "CATEGORY_NAME_KR")
    private String categoryNameKr;

    @Column(name = "CATEGORY_NAME_JP")
    private String categoryNameJp;

    @Column(name = "CATEGORY_COLOR")
    private String categoryColor;

    @Column(name = "CATEGORY_ICON")
    private String categoryIcon;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<SubCategoryEntity> subCategoryList;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MemberEntity.class)
    private MemberEntity member;

    @Deprecated
    public CategoryEntity() {
        // nop
    }

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @return 카데고리 인덱스
     */
    public Long getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 카테고리 이름(한국어)
     */
    public String getCategoryNameKr() {
        return categoryNameKr;
    }

    /**
     * <p>카테고리 이름(한국어)를 설정한다.</p>
     *
     * @param categoryNameKr 카테고리 이름(한국어)
     */
    public void setCategoryNameKr(String categoryNameKr) {
        this.categoryNameKr = categoryNameKr;
    }

    /**
     * <p>카테고리 이름(일본어)를 반환한다.</p>
     *
     * @return 카테고리 이름(일본어)
     */
    public String getCategoryNameJp() {
        return categoryNameJp;
    }

    /**
     * <p>카테고리 이름(일본어)를 설정한다.</p>
     *
     * @param categoryNameJp 카테고리 이름(일본어)
     */
    public void setCategoryNameJp(String categoryNameJp) {
        this.categoryNameJp = categoryNameJp;
    }

    /**
     * <p>카테고리 색을 반환한다.</p>
     *
     * @return 카테고리 색
     */
    public String getCategoryColor() {
        return categoryColor;
    }

    /**
     * <p>카테고리 색을 설정한다.</p>
     *
     * @param categoryColor 카테고리 색
     */
    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    /**
     * <p>카테고리 아이콘을 반환한다.</p>
     *
     * @return 카테고리 아이콘
     */
    public String getCategoryIcon() {
        return categoryIcon;
    }

    /**
     * <p>카테고리 아이콘을 설정한다.</p>
     *
     * @param categoryIcon 카테고리 아이콘
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    /**
     * <p>서브 카테고리 리스트를 반환한다.</p>
     *
     * @return 서브 카테고리 리스트
     */
    public List<SubCategoryEntity> getSubCategoryList() {
        return subCategoryList;
    }
}
