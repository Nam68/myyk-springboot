package yk.web.myyk.backend.service.category;

import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>서브 카테고리를 반환한다.</p>
 */
public interface FindSubCategory extends BaseService {

    /**
     * <p>서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param subCategoryIdx 서브 카테고리 인덱스
     */
    public void setSubCategoryIdx(long subCategoryIdx);

    /**
     * <p>서브 카테고리를 반환한다.</p>
     *
     * @return 서브 카테고리
     */
    public SubCategoryDTO getSubCategory();
}
