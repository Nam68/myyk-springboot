package yk.web.myyk.backend.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.exception.SystemException;

@Controller
public class HomepageController extends BaseController {

    @RequestMapping({"/", "/homepage"})
    public String index() throws SystemException {
        return "homepage";
    }

}
