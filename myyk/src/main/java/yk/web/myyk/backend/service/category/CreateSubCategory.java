package yk.web.myyk.backend.service.category;

import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>서브 카테고리를 생성한다.</p>
 */
public interface CreateSubCategory extends BaseService {

    /**
     * <p>서브 카테고리 이름(한국어)을 설정한다.</p>
     *
     * @param subCategoryNameKo 서브 카테고리 이름(한국어)
     */
    public void setSubCategoryNameKo(String subCategoryNameKo);

    /**
     * <p>서브 카테고리 이름(일본어)을 설정한다.</p>
     *
     * @param subCategoryNameJp 서브 카테고리 이름(일본어)
     */
    public void setSubCategoryNameJp(String subCategoryNameJp);

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(long categoryIdx);

    /**
     * <p>서브 카테고리를 반환한다.</p>
     *
     * @return 서브 카테고리
     */
    public SubCategoryDTO getSubCategory();
}
