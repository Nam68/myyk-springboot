package yk.web.myyk.backend.service.member;

import yk.web.myyk.backend.service.BaseService;

public interface CreateTmpMember extends BaseService {

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
     * <p>임시회원코드를 반환한다.</p>
     * 
     * @return 임시회원코드
     */
    public String getTmpCode();
}
