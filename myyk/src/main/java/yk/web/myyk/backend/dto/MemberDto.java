package yk.web.myyk.backend.dto;

import yk.web.myyk.util.enumerated.Region;

public class MemberDto extends BaseDto {

    private long memberIdx;

    private String email;

    private String password;

    private String nickname;

    private Region region;

    @Deprecated
    public MemberDto() {
        // nop
    }

    public MemberDto(String email, String password, String nickname, Region region) {
        setEmail(email);
        setPassword(password);
        setNickname(nickname);
        setRegion(region);
    }

    public long getMemberIdx() {
        return memberIdx;
    }

    public String getEmail() {
        return decrypt(email);
    }

    public void setEmail(String email) {
        this.email = encrypt(email);
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
