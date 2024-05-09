package yk.web.myyk.backend.controller.global;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebErrorController implements ErrorController {

    private static final String NO_HANDLER_ERROR = "error/noHandlerError";

    @RequestMapping(value = "/error")
    public String noHandlerFoundException() {
        return NO_HANDLER_ERROR;
    }
}
