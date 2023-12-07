package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.MemberType;

public interface LoginInfo {

    /**
     * <p>로그인 폼으로 정보를 세팅한다.</p>
     * 
     * @param memberEntity 회원 엔티티
     */
    public void setByLoginForm(MemberEntity memberEntity);

    /**
     * <p>이메일을 반환한다.</p>
     * 
     * @return 이메일
     */
    public String getEmail();

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

    /**
     * <p>회원 등급을 반환한다.</p>
     * 
     * @return 회원 등급
     */
    public MemberType getMemberType();
}
