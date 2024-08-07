package yk.web.myyk.backend.dto;

/**
 * <p>서브 카테고리 카드 DTO.</p>
 */
public class SubCategoryCardDTO extends BaseDTO {

    private long subCategoryIdx = 0;

    private String subCategoryName = "";

    public SubCategoryCardDTO(long subCategoryIdx, String subCategoryName) {
        this.subCategoryIdx = subCategoryIdx;
        this.subCategoryName = subCategoryName;
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
     * <p>서브 카테고리 이름을 반환한다.</p>
     *
     * @return 서브 카테고리 이름
     */
    public String getSubCategoryName() {
        return subCategoryName;
    }
}
