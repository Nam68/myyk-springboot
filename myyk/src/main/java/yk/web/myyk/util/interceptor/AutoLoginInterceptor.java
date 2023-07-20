package yk.web.myyk.util.interceptor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.LoginInfo;
import yk.web.myyk.backend.entity.member.AutoLoginEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.repository.AutoLoginRepository;
import yk.web.myyk.backend.repository.MemberRepository;
import yk.web.myyk.config.KeyName;
import yk.web.myyk.util.BaseApp;
import yk.web.myyk.util.cookie.CookieUtil;

/**
 * <p>자동 로그인 쿠키가 있으면 세션에 로그인 정보를 등록하는 인터셉터.</p>
 */
public class AutoLoginInterceptor extends BaseInterceptor implements HandlerInterceptor {
	
	@Autowired
	private AutoLoginRepository autoLoginRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (isResource(request)) {
			return true;
		}
		if (!hasRepositories(autoLoginRepository, memberRepository)) {
			return true;
		}
		
		String autoLoginSessionId = CookieUtil.getValue(KeyName.AUTO_LOGIN, request);

		// 자동 로그인 쿠키가 없는 경우는 그대로 진행
		if (autoLoginSessionId == null || autoLoginSessionId.isEmpty()) {
			return true;
		}
		
		Optional<AutoLoginEntity> autoLoginEntity = autoLoginRepository.findBySessionId(autoLoginSessionId);
		
		// 자동 로그인 엔티티를 가져오지 못했어도 그대로 진행
		if (!autoLoginEntity.isPresent()) {
			return true;
		}
		
		MemberEntity member = autoLoginEntity.get().getMemberEntity();
		Optional<MemberEntity> memberEntity = memberRepository.findById(member.getMemberIdx());
		
		// 해당 회원 정보를 가져오지 못했어도 그대로 진행
		if (!memberEntity.isPresent()) {
			return true;
		}
		
		LoginInfo loginInfo = new LoginInfo(memberEntity.get());
		request.getSession().setAttribute(BaseApp.getLoginInfoName(), loginInfo);
		return true;
	}
	
}
