package yk.web.myyk.backend.dto;

import java.util.Map;

import yk.web.myyk.backend.entity.category.CategoryEntity;

/**
 * <p>카테고리 DTO.</p>
 */
public class CategoryDTO extends BaseDTO {

    /**
     * <p>카테고리 인덱스.</p>
     */
    private long categoryIdx;

    /**
     * <p>카테고리 이름(한국어).</p>
     */
    private String categoryNameKr;

    /**
     * <p>카테고리 이름(일본어).</p>
     */
    private String categoryNameJp;

    /**
     * <p>카테고리 색.</p>
     */
    private String categoryColor;

    /**
     * <p>카테고리 아이콘.</p>
     */
    private String categoryIcon;

    /**
     * <p>서브 카테고리 리스트.</p>
     */
    private Map<Long, String> subCategoryList;

    public CategoryDTO() {
        // nop
    }

    public CategoryDTO(CategoryEntity entity) {
        setCategoryIdx(entity.getCategoryIdx());
        setCategoryNameKr(entity.getCategoryNameKr());
        setCategoryNameJp(entity.getCategoryNameJp());
        setCategoryIcon(entity.getCategoryColor());
        setCategoryIcon(entity.getCategoryIcon());
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
     * <p>카테고리 이름(한국어)을 반환한다.</p>
     *
     * @return 카테고리 이름(한국어)
     */
    public String getCategoryNameKr() {
        return categoryNameKr;
    }

    /**
     * <p>카테고리 이름(한국어)을 설정한다.</p>
     *
     * @param categoryNameKr 카테고리 이름(한국어)
     */
    public void setCategoryNameKr(String categoryNameKr) {
        this.categoryNameKr = categoryNameKr;
    }

    /**
     * <p>카테고리 이름(일본어)을 반환한다.</p>
     *
     * @return 카테고리 이름(일본어)
     */
    public String getCategoryNameJp() {
        return categoryNameJp;
    }

    /**
     * <p>카테고리 이름(일본어)을 설정한다.</p>
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
    public Map<Long, String> getSubCategoryList() {
        return subCategoryList;
    }

    /**
     * <p>서브 카테고리 리스트를 설정한다.</p>
     *
     * @param subCategoryList 서브 카테고리 리스트
     */
    public void setSubCategoryList(Map<Long, String> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

}
