package yk.web.myyk.backend.service.account;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>카테고리 인덱스로 카테고리를 반환한다.</p>
 */
public interface FindCategory extends BaseService {

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(long categoryIdx);

    /**
     * <p>카테고리를 반환한다.</p>
     *
     * @return 카테도리
     */
    public CategoryDTO getCategory();
}
