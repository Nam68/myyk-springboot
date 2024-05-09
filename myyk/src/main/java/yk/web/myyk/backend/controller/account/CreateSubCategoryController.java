package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/account/category/sub/create")
public class CreateSubCategoryController extends BaseController {

    private static final String INPUT = "account/category/createSubCategoryInput";

    @RequestMapping("/input")
    public String input(HttpServletRequest request) throws SystemException {
        return INPUT;
    }
}
