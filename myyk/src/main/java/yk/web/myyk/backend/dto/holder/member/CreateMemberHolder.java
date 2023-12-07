package yk.web.myyk.backend.dto.holder.member;

import yk.web.myyk.backend.dto.form.member.MemberForm;
import yk.web.myyk.backend.dto.holder.BaseHolder;
import yk.web.myyk.util.enumerated.Region;

/**
 * <p>회원가입 홀더.</p>
 */
public class CreateMemberHolder extends BaseHolder {

    /**
     * <p>이메일 로컬파트.</p>
     */
    private String emailLocalpart = "";

    /**
     * <p>이메일 도메인.</p>
     */
    private String emailDomain = "";

    /**
     * <p>닉네임.</p>
     */
    private String nickname = "";

    /**
     * <p>지역.</p>
     */
    private Region region = Region.KOREA;

    /**
     * <p>이메일 로컬파트를 반환한다.</p>
     * 
     * @return 이메일 로컬파트
     */
    public String getEmailLocalpart() {
        return emailLocalpart;
    }

    /**
     * <p>생성자.</p>
     */
    public CreateMemberHolder() {
        // nop
    }

    /**
     * <p>생성자.</p>
     * 
     * @param form 회원 정보.
     */
    public CreateMemberHolder(MemberForm form) {
        this.emailLocalpart = form.getEmailLocalpart();
        this.emailDomain = form.getEmailDomain();
        this.nickname = form.getNickname();
    }

    /**
     * <p>이메일 로컬파트를 설정한다.</p>
     * 
     * @param emailLocalpart 이메일 로컬파트
     */
    public void setEmailLocalpart(String emailLocalpart) {
        this.emailLocalpart = emailLocalpart;
    }

    /**
     * <p>이메일 도메인을 반환한다.</p>
     * 
     * @return 이메일 도메인
     */
    public String getEmailDomain() {
        return emailDomain;
    }

    /**
     * <p>이메일 도메인을 설정한다.</p>
     * 
     * @param emailDomain 이메일 도메인
     */
    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    /**
     * <p>닉네임을 반환한다.</p>
     * 
     * @return 닉네임
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * <p>닉네임을 설정한다.</p>
     * 
     * @param nickname 닉네임
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * <p>지역을 설정한다.</p>
     * 
     * @param region 지역
     */
    public void setRegion(Region region) {
        this.region = region;
    }
}
