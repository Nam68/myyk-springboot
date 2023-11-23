package yk.web.myyk.backend.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yk.web.myyk.backend.controller.BaseController;
import yk.web.myyk.util.annotation.DataCheck;
import yk.web.myyk.util.exception.SystemException;

@Controller
@RequestMapping("/member/tmp/code/create")
public class CreateTmpMemberCodeController extends BaseController {

    @RequestMapping("/input")
    public String input() throws SystemException {
        return "/member/createTmpMemberCodeInput";
    }

    @RequestMapping("/confirm")
    public String confirm() throws SystemException {
        
        
        return "redirect:/member/tmp/code/execute";
    }

    @RequestMapping("/execute")
    @DataCheck(target = {SystemException.class})
    public String execute() throws SystemException {
        return "redirect:/member/tmp/code/complete";
    }

    @RequestMapping("/complete")
    public String complete() throws SystemException {
        return "member/checkTmpMemberCodeInput";
    }

}
