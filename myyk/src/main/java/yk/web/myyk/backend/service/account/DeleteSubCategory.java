package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.service.BaseService;

/**
 * <p>서브 카테고리를 삭제한다.</p>
 */
public interface DeleteSubCategory extends BaseService {

    /**
     * <p>서브 카테고리 인덱스를 설정한다.</p>
     *
     * @param subCategoryIdx 서브 카테고리 인덱스를 설정한다.
     */
    public void setSubCategoryIdx(long subCategoryIdx);
}
