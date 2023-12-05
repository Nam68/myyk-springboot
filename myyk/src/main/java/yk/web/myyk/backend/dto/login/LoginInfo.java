package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.entity.member.MemberEntity;

public interface LoginInfo {

    /**
     * <p>로그인 폼으로 정보를 세팅한다.</p>
     * 
     * @param memberEntity 회원 엔티티
     */
    public void setByLoginForm(MemberEntity memberEntity);

    /**
     * <p>암호화된 이메일을 반환한다.</p>
     * 
     * @return 암호화된 이메일
     */
    public String getEncryptedEmail();

    /**
     * <p>복호화된 이메일을 반환한다.</p>
     * 
     * @return 복호화된 이메일
     */
    public String getDecryptedEmail();

    /**
     * <p>회원 아이콘을 반환한다.</p>
     * 
     * @return 회원 아이콘
     */
    public String getMemberIcon();

    /**
     * <p>닉네임을 반환한다.</p>
     * 
     * @return 닉네임
     */
    public String getNickname();
}
