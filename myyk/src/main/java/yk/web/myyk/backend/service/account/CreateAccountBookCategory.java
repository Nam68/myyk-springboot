package yk.web.myyk.backend.service.account;

import java.util.List;

import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.service.BaseService;

/**
 * <p>가계부 카테고리 생성 서비스.</p>
 */
public interface CreateAccountBookCategory extends BaseService {

    /**
     * <p>가계부 인덱스를 설정한다.</p>
     *
     * @param accountBookIdx 가계부 인덱스
     */
    public void setAccountBookIdx(long accountBookIdx);

    /**
     * <p>카테고리 인덱스 리스트를 설정한다.</p>
     *
     * @param categoryIdxList 카테고리 인덱스 리스트
     */
    public void setCategoryIdxList(List<Long> categoryIdxList);

    /**
     * <p>서브 카테고리 인덱스 리스트를 설정한다.</p>
     *
     * @param subCategoryIdxList 서브 카테고리 인덱스 리스트
     */
    public void setSubCategoryIdxList(List<Long> subCategoryIdxList);

    /**
     * 카테고리 리스트를 반환한다.
     *
     * @return 카테고리 리스트
     */
    public List<CategoryDTO> getCategoryList();

    /**
     * <p>서브 카테고리 리스트를 반환한다.</p>
     *
     * @return 서브 카테고리 리스트
     */
    public List<SubCategoryDTO> getSubCategoryList();

    /**
     * <p>가계부를 반환한다.</p>
     *
     * @return 가계부
     */
    public AccountBookDTO getAccountBook();
}
