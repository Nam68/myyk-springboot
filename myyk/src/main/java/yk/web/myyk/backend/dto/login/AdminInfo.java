package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.entity.member.MemberEntity;

public class AdminInfo implements LoginInfo {

    /**
     * <p>회원 아이콘.</p>
     */
    private String memberIcon;

    @Override
    public void setByLoginForm(MemberEntity memberEntity) {
        this.memberIcon = memberEntity.getMemberIcon();
    }

    @Override
    public String getMemberIcon() {
        return memberIcon;
    }
}
