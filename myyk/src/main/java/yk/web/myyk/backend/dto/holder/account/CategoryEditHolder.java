package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>카테고리 에디터 홀더.</p>
 */
public class CategoryEditHolder extends BaseHolder {

    /**
     * <p>카테고리 리스트.</p>
     */
    private List<CategoryDTO> categoryList = new ArrayList<>();

    /**
     * <p>카테고리 리스트를 반환한다.</p>
     *
     * @return 카테고리 리스트
     */
    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }
}
