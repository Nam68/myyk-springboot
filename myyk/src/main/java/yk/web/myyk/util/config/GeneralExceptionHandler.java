package yk.web.myyk.util.config;

import java.util.Map.Entry;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import yk.web.myyk.util.constant.KeyName;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.AppException;
import yk.web.myyk.util.exception.PermissionException;
import yk.web.myyk.util.exception.SystemException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({SystemException.class, Exception.class, RuntimeException.class})
    public ModelAndView systemExceptionHandler(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/systemError");
        mav.addObject(KeyName.ERROR_MESSAGE, e.getMessage());

        e.printStackTrace();

        return mav;
    }

    @ExceptionHandler({AppException.class})
    public ModelAndView systemExceptionHandler(AppException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/systemError");

        Entry<String, ErrorCode> firstEntry = e.getErrors().entrySet().iterator().next();
        String errorMessage = ErrorCode.getErrorMessage(firstEntry.getValue(), getClass());

        mav.addObject(KeyName.ERROR_MESSAGE, errorMessage);

        e.printStackTrace();

        return mav;
    }

    @ExceptionHandler({PermissionException.class})
    public ModelAndView permissionExceptionHandler(PermissionException e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/permissionError");
        mav.addObject(KeyName.PERMISSION_STATUS, e.getPermissionStatus());
        mav.addObject(KeyName.PERMISSION_TYPE, e.getMemberType());

        e.printStackTrace();

        return mav;
    }
}
