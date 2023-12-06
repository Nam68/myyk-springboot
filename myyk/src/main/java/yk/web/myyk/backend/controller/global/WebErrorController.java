package yk.web.myyk.backend.controller.global;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String noHandlerFoundException() {
        return "error/noHandlerError";
    }
}
