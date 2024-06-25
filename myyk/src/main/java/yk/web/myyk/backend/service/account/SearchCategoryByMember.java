package yk.web.myyk.backend.service.account;

import java.util.List;
import java.util.Locale;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.service.BaseService;
import yk.web.myyk.util.exception.SystemException;

/**
 * <p>회원 IDX를 통해 카테고리 리스트를 반환하는 서비스.</p>
 */
public interface SearchCategoryByMember extends BaseService {

    /**
     * <p>로케일을 설정한다.</p>
     *
     * @param locale 로케일
     */
    public void setLocale(Locale locale);

    /**
     * <p>카테고리 리스트를 반환한다.</p>
     *
     * @return 카테고리 리스트
     * @throws SystemException 시스템에러
     */
    public List<CategoryDTO> getCategoryList();
}
