package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.dto.BaseDto;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.MemberType;

public class AdminInfo extends BaseDto implements LoginInfo {

    /**
     * <p>이메일.</p>
     */
    private String email;

    /**
     *<p>닉네임.</p>
     */
    private String nickname;

    /**
     * <p>회원 아이콘.</p>
     */
    private String memberIcon;

    @Override
    public void setByLoginForm(MemberEntity memberEntity) {
        this.email = memberEntity.getEmail();
        this.nickname = memberEntity.getNickname();
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
    public String getNickname() {
        return nickname;
    }

    @Override
    public String getMemberIcon() {
        return memberIcon;
    }

    @Override
    public MemberType getMemberType() {
        return MemberType.ADMIN;
    }
}
