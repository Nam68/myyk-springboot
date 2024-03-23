package yk.web.myyk.backend.service.member;

import yk.web.myyk.backend.service.BaseService;

/**
 * <p>임시회원코드를 통해 이메일을 불러온다.</p>
 */
public interface FindEmailByTmpCode extends BaseService {

    /**
     * <p>임시회원코드를 설정한다.</p>
     *
     * @param tmpCode 임시회원코드
     */
    public void setTmpCode(String tmpCode);

    /**
     * <p>이메일 로컬파트를 반환한다.</p>
     *
     * @return 이메일 로컬파트
     */
    public String getEmailLocalpart();

    /**
     * <p>이메일 도메인을 반환한다.</p>
     *
     * @return 이메일 도메인
     */
    public String getEmailDomain();

}
