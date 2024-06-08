package yk.web.myyk.backend.dto.login;

import yk.web.myyk.backend.dto.BaseDTO;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.MemberType;
import yk.web.myyk.util.enumerated.Region;

public class MemberInfo extends BaseDTO implements LoginInfo {

    /**
     * <p>회원 IDX.</p>
     */
    private long memberIdx;

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
        this.memberIdx = memberEntity.getMemberIdx();
        this.email = memberEntity.getEmail();
        this.nickname = memberEntity.getNickname();
        this.memberIcon = memberEntity.getMemberIcon();
        this.region = memberEntity.getRegion();
        this.memberType = memberEntity.getMemberType();
    }

    @Override
    public long getMemberIdx() {
        return memberIdx;
    }

    @Override
    public String getEmail() {
        return email;
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
