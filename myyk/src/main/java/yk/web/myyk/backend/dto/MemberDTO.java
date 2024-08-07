package yk.web.myyk.backend.dto;

import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.util.enumerated.Region;

public class MemberDTO extends BaseDTO {

    private long memberIdx;

    private String email;

    private String password;

    private String nickname;

    private String nicknameLang;

    private Region region;

    @Deprecated
    public MemberDTO() {
        // nop
    }

    public MemberDTO(MemberEntity entity) {
        setMemberIdx(entity.getMemberIdx());
        setEmail(entity.getEmail());
        setPassword(entity.getPassword());
        setNickname(entity.getNickname());
        setNicknameLang(entity.getNicknameLang());
        setRegion(entity.getRegion());
    }

    public MemberDTO(long memberIdx, String email, String password, String nickname, String nicknameLang, Region region) {
        this(email, password, nickname, nicknameLang, region);
        setMemberIdx(memberIdx);
    }

    public MemberDTO(String email, String password, String nickname, String nicknameLang, Region region) {
        setEmail(email);
        setPassword(password);
        setNickname(nickname);
        setNicknameLang(nicknameLang);
        setRegion(region);
    }

    public long getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(long memberIdx) {
        this.memberIdx = memberIdx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNicknameLang() {
        return nicknameLang;
    }

    public void setNicknameLang(String nicknameLang) {
        this.nicknameLang = nicknameLang;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
