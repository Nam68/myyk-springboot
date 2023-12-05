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
     * <p>회원 아이콘을 반환한다.</p>
     * 
     * @return 회원 아이콘
     */
    public String getMemberIcon();
}
