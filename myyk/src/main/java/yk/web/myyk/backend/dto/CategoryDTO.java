package yk.web.myyk.backend.dto;

import java.util.Map;

/**
 * <p>카테고리 DTO.</p>
 */
public class CategoryDTO {

    /**
     * <p>카테고리 인덱스.</p>
     */
    private long categoryIdx;

    /**
     * <p>카테고리 이름.</p>
     */
    private String categoryName;

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
     * <p>카테고리 이름을 반환한다.</p>
     *
     * @return 카테고리 이름
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * <p>카테고리 이름을 설정한다.</p>
     *
     * @param categoryName 카테고리 이름
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
     * <p>카테고리 이름을 설정한다.</p>
     *
     * @param categoryColor 카테고리 이름
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
