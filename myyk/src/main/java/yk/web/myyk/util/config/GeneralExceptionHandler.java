package yk.web.myyk.util.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.ApiException;
import yk.web.myyk.util.exception.PermissionException;
import yk.web.myyk.util.exception.SystemException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({SystemException.class, Exception.class, RuntimeException.class})
    public ModelAndView systemExceptionHandler(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/systemError");
        mav.addObject("errorMessage", e.getMessage());

        e.printStackTrace();

        return mav;
    }

    @ExceptionHandler({PermissionException.class})
    public ModelAndView permissionExceptionHandler(PermissionException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/permissionError");
        mav.addObject("status", e.getPermissionStatus());
        mav.addObject("memberType", e.getMemberType());

        e.printStackTrace();

        return mav;
    }
}
