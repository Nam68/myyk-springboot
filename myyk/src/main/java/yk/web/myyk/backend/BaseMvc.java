package yk.web.myyk.backend;

import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.errorCode.ErrorCode;
import yk.web.myyk.util.exception.SystemException;

public class BaseMvc extends BaseApp {

    /**
     * <p>이메일 배열의 길이(이메일 로컬파트 + 이메일 도메인 = 2)</p>
     */
    private static final int EMAIL_PARTS_NUMBER = 2;

    /**
     * <p>이메일 로컬파트의 배열에서의 위치</p>
     */
    private static final int EMAIL_LOCALPART = 0;

    /**
     * <p>이메일 도메인의 배열에서의 위치</p>
     */
    private static final int EMAIL_DOMAIN = 1;

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

    /**
     * <p>이메일에서 로컬파트를 반환한다.</p>
     * 
     * @param email 이메일
     * @return 이메일 로컬파트
     */
    protected static String getEmailLocalpart(String email) {
        return devideEmail(email)[EMAIL_LOCALPART];
    }

    /**
     * <p>이메일에서 도메인을 반환한다.</p>
     * 
     * @param email 이메일
     * @return 이메일 도메인
     */
    protected static String getEmailDomain(String email) {
        return devideEmail(email)[EMAIL_DOMAIN];
    }

    /**
     * <p>이메일을 분리한다.</p>
     * 
     * @param email 이메일
     * @return 분리된 이메일의 문자열 배열
     */
    private static String[] devideEmail(String email) {
        String[] emailParts = email.split("@");
        if (emailParts.length != EMAIL_PARTS_NUMBER) {
            throw new SystemException(ErrorCode.EE_ME_103, BaseMvc.class);
        }
        return emailParts;
    }
    
    protected static String getCombinedEmail(String emailLocalpart, String emailDomain) {
        return emailLocalpart + "@" + emailDomain;
    }

}
