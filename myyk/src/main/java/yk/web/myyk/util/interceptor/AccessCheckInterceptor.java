package yk.web.myyk.util.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.util.annotation.AccessCheck;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.exception.PermissionException;
import yk.web.myyk.util.exception.PermissionException.PermissionStatus;

/**
 * <p>로그인 회원의 권한을 체크하는 인터셉터.</p>
 */
public class AccessCheckInterceptor extends BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HandlerMethod handlerMethod = getHandlerMethod(handler);
        if (handlerMethod == null) {
        	return true;
        }

        // 어노테이션이 설정되지 않았다면 모든 접근이 가능하므로 통과
        AccessCheck accessCheck = getAnnotation(AccessCheck.class, handlerMethod);
        if (accessCheck == null) {
            return true;
        }

        // 멤버타입을 설정
        // 로그인 정보가 없거나, 로그인 정보 상 멤버타입이 없는 경우 = 미로그인 상태로 설정
        // 로그인 정보가 있는 경우 해당 멤버타입으로 설정
        LoginInfo loginInfo = getSessionAttribute(request, LOGIN_INFO, LoginInfo.class);
        MemberType memberType = (loginInfo == null || loginInfo.getMemberType() == null) ? MemberType.NO_LOGIN : loginInfo.getMemberType();

        // 로그인 멤버타입의 랭크가 허용치보다 작은 경우 에러
        if (memberType.getRank() < accessCheck.permitted().getRank()) {
            throw new PermissionException(PermissionStatus.PERMITTED, accessCheck.permitted());
        }

        // 허용 랭크 이상이어도 접속거부에 해당하는 멤버타입인 경우 에러
        for (MemberType type : accessCheck.denied()) {
            if (type.equals(memberType)) {
                throw new PermissionException(PermissionStatus.DENIED, memberType);
            }
        }

        return true;
    }
}
