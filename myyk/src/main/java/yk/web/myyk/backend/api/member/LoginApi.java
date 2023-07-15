package yk.web.myyk.backend.api.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import yk.web.myyk.backend.api.BaseApi;
import yk.web.myyk.backend.dto.LoginDTO;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.util.cookie.CookieApp;
import yk.web.myyk.util.cookie.CookieUtil;
import yk.web.myyk.util.enumerated.Error;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

@RestController
@RequestMapping("/member")
public class LoginApi extends BaseApi {
	
	/**
	 * <p>로그인한다.</p>
	 * 
	 * @param dto 로그인 정보
	 * @param session 세션
	 * @return 성공여부
	 * @throws SystemException 시스템에러
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(LoginDTO dto, HttpSession session, HttpServletResponse response) throws SystemException {
		
		LoginInfo loginInfo = getService().getLogin().find(dto);
		if (loginInfo == null) {
			// 로그인 정보가 DB에 없으면 에러 송신
			return Error.ERROR.name();
		}
		
		session.setAttribute(LOGIN_INFO, loginInfo);
		
		// 자동 로그인 쿠키 작성
		if (dto.isAutoLoginCheck()) {
			String autoLoginSessionId = getService().getLogin().createAutoLoginSession(dto);
			if (autoLoginSessionId == null || autoLoginSessionId.isEmpty()) {
				throw new SystemException(ErrorCode.CT_102, getClass());
			} else {
				CookieUtil.setCookie(CookieApp.AUTO_LOGIN, autoLoginSessionId, response);
			}
		}
		
		return Error.SUCCESS.name();
	}
}
