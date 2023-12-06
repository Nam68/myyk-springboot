package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.dto.BaseDto;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.Region;

public class MemberInfo extends BaseDto implements LoginInfo {

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

    /**
     * <p>지역.</p>
     */
    private Region region;

    /**
     * <p>회원 등급.</p>
     */
    private MemberType memberType;

    @Override
    public void setByLoginForm(MemberEntity memberEntity) {
        this.email = memberEntity.getEmail();
        this.nickname = memberEntity.getNickname();
        this.memberIcon = memberEntity.getMemberIcon();
        this.region = memberEntity.getRegion();
        this.memberType = memberEntity.getMemberType();
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

    /**
     * <p>지역을 반환한다.</p>
     * 
     * @return 지역
     */
    public Region getRegion() {
        return region;
    }

    /**
     * <p>회원 등급을 반환한다.</p>
     * 
     * @return 회원 등급
     */
    @Override
    public MemberType getMemberType() {
        return memberType;
    }
}