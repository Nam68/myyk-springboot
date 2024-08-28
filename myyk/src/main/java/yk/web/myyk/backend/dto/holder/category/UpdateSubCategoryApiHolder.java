package yk.web.myyk.backend.dto.holder.category;

import yk.web.myyk.backend.dto.holder.BaseApiHolder;

public class UpdateSubCategoryApiHolder extends BaseApiHolder {

    private String subCategoryNameKo;

    private String subCategoryNameJp;

    public void setSubCategoryNameKo(String subCategoryNameKo) {
        this.subCategoryNameKo = subCategoryNameKo;
    }

    public String getSubCategoryNameKo() {
        return subCategoryNameKo;
    }

    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }

    public String getSubCategoryNameJp() {
        return subCategoryNameJp;
    }
}
