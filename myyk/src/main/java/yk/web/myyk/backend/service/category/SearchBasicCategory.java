package yk.web.myyk.backend.service.category;

import java.util.List;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>기본 카테고리를 검색한다.</p>
 */
public interface SearchBasicCategory extends BaseService {

    /**
     * <p>기본 카테고리를 반환한다.</p>
     *
     * @return 기본 카테고리
     */
    public List<CategoryDTO> getBasicCategory();
}
