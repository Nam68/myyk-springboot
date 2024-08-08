package yk.web.myyk.backend.service.category;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>회원 인덱스를 통해 카테고리를 반환한다.</p>
 */
public interface FindCategoryByMember extends BaseService {

    /**
     * <p>회원 인덱스를 설정한다.</p>
     *
     * @param memberIdx 회원 인덱스
     */
    public void setMemberIdx(long memberIdx);

    /**
     * <p>카테고리를 반환한다.</p>
     *
     * @return 카테고리
     */
    public CategoryDTO getCategory();
}
