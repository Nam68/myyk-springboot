package yk.web.myyk.backend.logic.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import yk.web.myyk.backend.dto.SubCategoryCardDTO;
import yk.web.myyk.backend.dto.SubCategoryDTO;
import yk.web.myyk.backend.dto.holder.category.CreateSubCategoryCardHtmlHolder;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.category.CreateSubCategoryCardHtml;
import yk.web.myyk.util.constant.ModuleName;
import yk.web.myyk.util.constant.MyLocale;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateSubCategoryCardHtmlLogic extends BaseLogic implements CreateSubCategoryCardHtml {

    private List<SubCategoryDTO> subCategoryList;

    private String html;

    @Override
    public void setSubCategoryList(List<SubCategoryDTO> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    @Override
    public void validate() throws SystemException, AppException {
        // nop
    }

    @Override
    public void excute() throws SystemException, AppException {
        validate();

        List<SubCategoryCardDTO> subCategoryCardList = new ArrayList<>();

        String language = getCurrentLanguage(this.getClass());

        for (SubCategoryDTO subCategory : subCategoryList) {
            long subCategoryIdx = subCategory.getSubCategoryIdx();
            String subCategoryName = MyLocale.isKorean(language) ? subCategory.getSubCategoryNameKr() : subCategory.getSubCategoryNameJp();
            subCategoryCardList.add(new SubCategoryCardDTO(subCategoryIdx, subCategoryName));
        }

        CreateSubCategoryCardHtmlHolder holder = new CreateSubCategoryCardHtmlHolder(subCategoryCardList);
        html = getFreeMarkerFactory().setTemplateName(ModuleName.SUB_CATEGORY_CARD).setParameter(holder).get();
    }

    @Override
    public String getHtml() {
        return html;
    }

}
