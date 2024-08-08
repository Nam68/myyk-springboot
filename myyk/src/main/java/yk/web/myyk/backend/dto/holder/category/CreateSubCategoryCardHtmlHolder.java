package yk.web.myyk.backend.dto.holder.category;

import java.util.ArrayList;
import java.util.List;

import yk.web.myyk.backend.dto.SubCategoryCardDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;

/**
 * <p>서브 카테고리 카드 HTML 생성 홀더.</p>
 */
public class CreateSubCategoryCardHtmlHolder extends BaseHolder {

    private List<SubCategoryCardDTO> subCategoryList = new ArrayList<>();

    public CreateSubCategoryCardHtmlHolder(List<SubCategoryCardDTO> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    /**
     * <p>서브 카테고리 리스트를 반환한다.</p>
     *
     * @return 서브 카테고리 리스트
     */
    public List<SubCategoryCardDTO> getSubCategoryList() {
        return subCategoryList;
    }
}
