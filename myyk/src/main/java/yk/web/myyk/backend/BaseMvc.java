package yk.web.myyk.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.backend.factory.ServiceFactory;
import yk.web.myyk.util.BaseApp;

public class BaseMvc extends BaseApp {

//	protected static LoginInfo getLoginInfo() {
//		HttpSession session = getCurrentSession();
//		return (LoginInfo) session.getAttribute(LOGIN_INFO);
//	}

//	private static HttpSession getCurrentSession() {
//		ServletRequestAttributes servletRequestAttribute = 
//				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//	    HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
//	    return httpSession;
//	}

}
