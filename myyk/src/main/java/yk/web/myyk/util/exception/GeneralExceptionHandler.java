package yk.web.myyk.util.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import yk.web.myyk.config.KeyName;
import yk.web.myyk.util.enumerated.Category;

@ControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler({SystemException.class, Exception.class, RuntimeException.class})
	public ModelAndView systemExceptionHandler(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("global/globalError");
		mav.addObject("errorMessage", e.getMessage());
		mav.addObject(KeyName.CATEGORY, Category.HOME);
		
		e.printStackTrace();
		
		return mav;
	}
	
	@ExceptionHandler({PermissionException.class})
	public ModelAndView permissionExceptionHandler(PermissionException e) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("global/permissionError");
		mav.addObject("status", e.getPermissionStatus());
		mav.addObject("memberType", e.getMemberType());
		mav.addObject(KeyName.CATEGORY, Category.HOME);
		
		e.printStackTrace();
		
		return mav;
	}
	
}
