package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>서브 카테고리 카드 HTML을 생성한다.</p>
 */
public interface CreateSubCategoryCardHtml extends BaseService {

    /**
     * <p>서브 카테고리 리스트를 설정한다.</p>
     *
     * @param subCategoryList 서브 카테고리 리스트
     */
    public void setSubCategoryList(List<SubCategoryDTO> subCategoryList);

    /**
     * <p>HTML코드를 반환한다.</p>
     *
     * @return HTML코드
     */
    public String getHtml();
}
