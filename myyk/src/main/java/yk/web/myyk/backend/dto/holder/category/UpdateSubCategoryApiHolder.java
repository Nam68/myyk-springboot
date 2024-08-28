package yk.web.myyk.backend.dto.holder.category;

import yk.web.myyk.backend.dto.holder.BaseApiHolder;

public class UpdateSubCategoryApiHolder extends BaseApiHolder {

    private String subCategoryNameKr;

    private String subCategoryNameJp;

    public void setSubCategoryNameKr(String subCategoryNameKr) {
        this.subCategoryNameKr = subCategoryNameKr;
    }

    public String getSubCategoryNameKr() {
        return subCategoryNameKr;
    }

    public void setSubCategoryNameJp(String subCategoryNameJp) {
        this.subCategoryNameJp = subCategoryNameJp;
    }

    public String getSubCategoryNameJp() {
        return subCategoryNameJp;
    }
}
