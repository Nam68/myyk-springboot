package yk.web.myyk.backend.service.category;

import java.util.List;

import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>서브 카테고리 목록을 가져오는 서비스.</p>
 */
public interface SearchSubCategoryByCategory extends BaseService {

    /**
     * <p>카테고리 인덱스를 설정한다.</p>
     *
     * @param categoryIdx 카테고리 인덱스
     */
    public void setCategoryIdx(long categoryIdx);

    /**
     * <p>서브 카테고리 리스트를 반환한다.</p>
     *
     * @return 서브 카테고리 리스트
     */
    public List<SubCategoryDTO> getSubCategoryList();
}
