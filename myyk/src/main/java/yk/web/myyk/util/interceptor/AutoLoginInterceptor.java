package yk.web.myyk.util.interceptor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.login.LoginInfo;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.entity.token.LoginToken;
import yk.web.myyk.backend.repository.LoginTokenRepository;
import yk.web.myyk.backend.repository.MemberRepository;
import yk.web.myyk.util.cookie.CookieUtil;

/**
 * <p>자동 로그인 쿠키가 있으면 세션에 로그인 정보를 등록하는 인터셉터.</p>
 */
public class AutoLoginInterceptor extends BaseInterceptor {

    @Autowired
    private LoginTokenRepository loginTokenRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (isResource(request)) {
            return true;
        }
        if (!hasRepositories(loginTokenRepository, memberRepository)) {
            return true;
        }

        String tokenId = decrypt(CookieUtil.getValue(AUTO_LOGIN, request));

        // 자동 로그인 쿠키가 없는 경우는 그대로 진행
        if (tokenId == null || tokenId.isEmpty()) {
            return true;
        }

        Optional<LoginToken> loginToken = loginTokenRepository.findByTokenId(tokenId);

        // 자동 로그인 토큰이 없어도 그대로 진행
        if (!loginToken.isPresent()) {
            return true;
        }

        MemberEntity member = loginToken.get().getMemberEntity();

        // 해당 회원 정보를 가져오지 못했어도 그대로 진행
        if (member == null) {
            return true;
        }

        LoginInfo loginInfo = member.getLoginInfo();
        setSessionAttribute(request, LOGIN_INFO, loginInfo);

        loginToken.get().updateLastUsedTime();
        return true;
    }

}
