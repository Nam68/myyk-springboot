package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.dto.BaseDto;
import yk.web.myyk.backend.entity.member.MemberEntity;

public class AdminInfo extends BaseDto implements LoginInfo {

    /**
     * <p>이메일.</p>
     */
    private String email;

    /**
     * <p>회원 아이콘.</p>
     */
    private String memberIcon;

    @Override
    public void setByLoginForm(MemberEntity memberEntity) {
        this.email = memberEntity.getEmail();
        this.memberIcon = memberEntity.getMemberIcon();
    }

    @Override
    public String getEncryptedEmail() {
        return email;
    }

    @Override
    public String getDecryptedEmail() {
        return decrypt(email);
    }

    @Override
    public String getMemberIcon() {
        return memberIcon;
    }
}
