package yk.web.myyk.backend.service.member;

import yk.web.myyk.backend.service.BaseService;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>회원을 생성한다.</p>
 */
public interface CreateMember extends BaseService {

    /**
     * <p>이메일 로컬파트를 설정한다.</p>
     *
     * @param emailLocalpart 이메일 로컬파트
     */
    public void setEmailLocalpart(String emailLocalpart);

    /**
     * <p>이메일 도메인을 설정한다.</p>
     *
     * @param emailDomain 이메일 도메인
     */
    public void setEmailDomain(String emailDomain);

    /**
     * <p>비밀번호를 설정한다.</p>
     *
     * @param password 비밀번호
     */
    public void setPassword(String password);

    /**
     * <p>비밀번호 확인을 설정한다.</p>
     *
     * @param passwordCheck 비밀번호 확인
     */
    public void setPasswordCheck(String passwordCheck);

    /**
     * <p>닉네임을 설정한다.</p>
     *
     * @param nickname 닉네임
     */
    public void setNickname(String nickname);

    /**
     * <p>닉네임 타언어를 설정한다.</p>
     *
     * @param nicknameLang 닉네임 타언어
     */
    public void setNicknameLang(String nicknameLang);

    /**
     * <p>지역을 설정한다.</p>
     *
     * @param region 지역
     */
    public void setRegion(Region region);

    /**
     * <p>이메일을 반환한다.</p>
     *
     * @return 이메일
     */
    public String getEmail();
}
