package yk.web.myyk.backend.entity.category;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import yk.web.myyk.backend.entity.BaseEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;

@Entity
@Table(name = "CATEGORY_TBL")
public class CategoryEntity extends BaseEntity {

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

    @Column(name = "SORT_NO")
    private int sortNo;

    @Column(name = "BASIC")
    private boolean basic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<SubCategoryEntity> subCategoryList;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MemberEntity.class)
    private MemberEntity member;

    @Deprecated
    public CategoryEntity() {
        // nop
    }
    @Deprecated
    public CategoryEntity(long categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public CategoryEntity(String categoryNameKr, String categoryNameJp, String categoryColor, String categoryIcon, int sortNo, MemberEntity member) {
        setCategoryNameKr(categoryNameKr);
        setCategoryNameJp(categoryNameJp);
        setCategoryColor(categoryColor);
        setCategoryIcon(categoryIcon);
        setSortNo(sortNo);
        setMember(member);
        setDeleted(false);
        setBasic(false);
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

    /**
     * <p>서브 카테고리 하나를 리스트에 추가한다.</p>
     *
     * @param subCategory 서브 카테고리
     */
    public void setSubCategory(SubCategoryEntity subCategory) {
        subCategoryList.add(subCategory);
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

    /**
     * <p>기본 여부를 반환한다.</p>
     *
     * @return 기본 여부
     */
    public boolean isBasic() {
        return basic;
    }

    /**
     * <p>기본 여부를 설정한다.</p>
     *
     * @param basic 기본 여부
     */
    public void setBasic(boolean basic) {
        this.basic = basic;
    }

    /**
     * <p>회원을 설정한다.</p>
     *
     * @param member 회원
     */
    public void setMember(MemberEntity member) {
        this.member = member;
    }
}
