package yk.web.myyk.backend.api.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.AccountDTO;
import yk.web.myyk.backend.dto.form.account.CreateSubCategoryForm;
import yk.web.myyk.backend.service.account.CreateSubCategory;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping(path = "/account", method = RequestMethod.POST)
public class AccountApi extends BaseApi {

    /**
     * <p>회계를 등록한다.</p>
     *
     * @param dto 회계DTO
     * @return 성공여부
     * @throws SystemException 시스템에러
     */
    @RequestMapping("/create")
    public String createAccount(AccountDTO dto) throws ApiException {
        try {
//          getService().getAccount().createAccount(dto);
        } catch (SystemException e) {
            throw new ApiException(e.getMessage());
        }
        return Error.SUCCESS.getValue();
    }

    @RequestMapping("/category/sub/create")
    public String createSubCategory(CreateSubCategoryForm form) throws ApiException {
        String json = "";
        CreateSubCategory logic = getService().getCreateSubCategory();
        try {
            logic.setCategoryIdx(form.getCategoryIdx());
            logic.setSubCategoryNameKo(form.getSubCategoryNameKo());
            logic.setSubCategoryNameJp(form.getSubCategoryNameJp());
            logic.excute();

            Gson gson = new Gson();
            json = gson.toJson(logic.getSubCategory());

        } catch (AppException e) {
            json = getErrorJson(e.getErrors());
        }
        return json;
    }

}
