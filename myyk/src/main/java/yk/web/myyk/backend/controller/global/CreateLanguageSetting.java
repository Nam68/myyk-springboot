package yk.web.myyk.backend.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.exception.SystemException;

@Controller
public class CreateLanguageSetting extends BaseController {

    @RequestMapping("/languageSetting/create")
    public String input() throws SystemException {
        return "createLanguageSetting";
    }

}
