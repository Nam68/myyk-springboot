package yk.web.myyk.backend.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping
    public String main() throws SystemException {
        return "account/main";
    }
}
