package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.SystemException;

@Controller
@AccessCheck(permitted = MemberType.MEMBER)
@RequestMapping("/category/create")
public class CreateCategoryController extends BaseController {

    @RequestMapping("/input")
    public String input() throws SystemException {

        return "account/category/createCategoryInput";
    }
}
