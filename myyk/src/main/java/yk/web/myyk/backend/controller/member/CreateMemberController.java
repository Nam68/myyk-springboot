package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/member/create")
public class CreateMemberController extends BaseController {

    @RequestMapping("/input")
    public String input() throws SystemException {
        return "member/createMemberInput";
    }

}
