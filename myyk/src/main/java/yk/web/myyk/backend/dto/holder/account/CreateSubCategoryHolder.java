package yk.web.myyk.backend.dto.holder.account;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.dto.CategoryDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.util.KeyName;
import yk.web.myyk.util.constant.MyLocale;

/**
 * <p>서브 카테고리 생성 홀더.</p>
 */
public class CreateSubCategoryHolder extends BaseHolder {

    private long categoryIdx = 0;

    private String categoryName = "";

    private String subCategoryNameKo = "";

    private String subCategoryNameJp = "";

    private List<SubCategoryDTO> subCategoryList = new ArrayList<>();

    @Deprecated
    public CreateSubCategoryHolder() {
        // TODO FOR TEST
    }

    public CreateSubCategoryHolder(CategoryDTO category, List<SubCategoryDTO> subCategoryList, String locale) {
        this.categoryIdx = category.getCategoryIdx();
        this.categoryName = MyLocale.isKorean(locale) ? category.getCategoryNameKo() : category.getCategoryNameJp();
        this.subCategoryList = subCategoryList;
    }

    /**
     * <p>카테고리 인덱스를 반환한다.</p>
     *
     * @return 카테고리 인덱스
     */
    public long getCategoryIdx() {
        return categoryIdx;
    }

    /**
     * <p>카테고리 이름을 반환한다.</p>
     *
     * @return 카테고리 이름
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * <p>서브 카테고리 이름(한국어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(한국어)
     */
    public String getSubCategoryNameKo() {
        return subCategoryNameKo;
    }

    /**
     * <p>서브 카테고리 이름(일본어)를 반환한다.</p>
     *
     * @return 서브 카테고리 이름(일본어)
     */
    public String getSubCategoryNameJp() {
        return subCategoryNameJp;
    }

    /**
     * <p>서브 카테고리 리스트를 반환한다.</p>
     *
     * @return 서브 카테고리 리스트
     */
    public List<SubCategoryDTO> getSubCategoryList() {
        return subCategoryList;
    }
}
